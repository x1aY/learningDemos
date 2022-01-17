package cn.hhu.xy.config.database;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author cn.hhu.xy
 * @date 2021/8/15
 * @description 
 * */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD })
public @interface DsSwitcher {
    DSKey value() default DSKey.xyMysql;
}
