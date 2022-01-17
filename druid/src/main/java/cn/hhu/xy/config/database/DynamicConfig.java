package cn.hhu.xy.config.database;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DynamicConfig {

    @Value("${mybatis.type-aliases-package}")
    private String typeAliasesPackage;

    @Value("${mybatis.mapper-locations}")
    private String mapperLocations;

    @Primary
    @Bean("xyMysql")
    @ConfigurationProperties(prefix = "spring.datasource.dynamic.xy-mysql")
    public DataSource xyMysql(@Qualifier("myDruidDataSource")DruidDataSource myDruidDataSource) {
        return myDruidDataSource;
    }

    @Bean("xcgMysql")
    @ConfigurationProperties(prefix = "spring.datasource.dynamic.xcg-mysql")
    public DataSource xcgMysql(@Qualifier("myDruidDataSource")DruidDataSource myDruidDataSource) {
        return myDruidDataSource;
    }

    @Bean("dynamicDataSource")
    public DataSource dynamicDataSource(@Qualifier("xyMysql")DataSource xyMysql,
                                        @Qualifier("xcgMysql")DataSource xcgMysql) {
        DynamicRoutingDS dynamicRoutingDataSource = new DynamicRoutingDS();
        Map<Object, Object> dataSourceMap = new HashMap<>(3);
        dataSourceMap.put(DSKey.xyMysql.name(), xyMysql);
        dataSourceMap.put(DSKey.xcgMysql.name(), xcgMysql);
        // 将 master 数据源作为默认指定的数据源
        dynamicRoutingDataSource.setDefaultTargetDataSource(xyMysql);
        // 将 master 和 slave 数据源作为指定的数据源
        dynamicRoutingDataSource.setTargetDataSources(dataSourceMap);
        // 将数据源的 key 放到数据源上下文的 key 集合中，用于切换时判断数据源是否有效
        DynamicDSContextHolder.dataSourceKeys.addAll(dataSourceMap.keySet());
        // 将 Slave 数据源的 key 放在集合中，用于轮循
        DynamicDSContextHolder.slaveDataSourceKeys.addAll(dataSourceMap.keySet());
        DynamicDSContextHolder.slaveDataSourceKeys.remove(DSKey.xyMysql.name());
        return dynamicRoutingDataSource;
    }

    /**
     * 配置 SqlSessionFactoryBean
     * @description  在这里是为了将 MyBatis 的 mapper 位置和持久层接口的别名设置到
     * Bean 的属性中，如果没有使用 *.xml 则可以不用该配置，否则将会产生 invalid bond statement 异常
     * @return the sql session factory bean
     */
    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean(@Qualifier("dynamicDataSource")DataSource dynamicDataSource) throws IOException {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setTypeAliasesPackage(typeAliasesPackage);
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().
                getResources(mapperLocations));
        // 配置数据源，此处配置为关键配置，如果没有将 dynamicDataSource 作为数据源则不能实现切换
        sqlSessionFactoryBean.setDataSource(dynamicDataSource);
        return sqlSessionFactoryBean;
    }

    /**
     * 注入 DataSourceTransactionManager 用于事务管理
     */
    @Bean
    public PlatformTransactionManager transactionManager(@Qualifier("dynamicDataSource")DataSource dynamicDataSource) {
        return new DataSourceTransactionManager(dynamicDataSource);
    }




}
