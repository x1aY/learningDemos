package cn.hhu.xy.config.database;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @author cn.hhu.xy
 * @date 2021/8/13
 * @description 动态数据源切换的切面，切 DAO 层，
 * 通过 DAO 层方法名判断使用哪个数据源，实现数据源切换;
 * 关于切面的 Order 可以不设，因为 @Transactional 是最低的，取决于其他切面的设置，
 * 并且在org.springframework.core.annotation.AnnotationAwareOrderComparator 会重新排序
 * */
@Slf4j
@Component
@Aspect
public class DynamicDSAspect {

    private final String[] QUERY_PREFIX = {"get"};

    @Pointcut("execution(* cn.hhu.xy.dao..*.*(..))")
    public void daoMethod() {
    }

    /**
     * 在调用前切换数据源
     */
    @Before("daoMethod()")
    public void transServiceMethod(JoinPoint joinPoint) {
        System.out.println(joinPoint);
        switchDataSource(joinPoint);
    }

    /**
     * 在调用后（包括有异常的情况下），清空数据源标识
     */
    @After("daoMethod()")
    public void clearDs(JoinPoint joinPoint) {
        clearDataSource(joinPoint);
    }

    /**
     * 根据注解改变数据源
     */
    private void switchDataSource(JoinPoint joinPoint) {
        MethodSignature signature =
                (MethodSignature) joinPoint.getSignature();
        DsSwitcher dsSwitcher =
                signature.getMethod().getAnnotation(DsSwitcher.class);
        if (!Objects.isNull(dsSwitcher)) {
            dsSwitcher.value();
            DSKey annoEnum = dsSwitcher.value();
            for(DSKey key : DSKey.values()){
                if(key == annoEnum){
                    DynamicDSContextHolder.setDataSourceKey(annoEnum.name());
                }
            }

        }
    }

    /**
     * 在每次调用之后，清空数据源
     */
    private void clearDataSource(JoinPoint joinPoint) {
        MethodSignature signature =
                (MethodSignature) joinPoint.getSignature();
        DsSwitcher dsSwitcher =
                signature.getMethod().getAnnotation(DsSwitcher.class);
        if (!Objects.isNull(dsSwitcher)) {
            dsSwitcher.value();
            DynamicDSContextHolder.clearDataSourceKey();
        }
    }

}
