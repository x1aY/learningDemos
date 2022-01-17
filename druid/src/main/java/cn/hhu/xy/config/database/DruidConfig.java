package cn.hhu.xy.config.database;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author cn.hhu.xy
 * @date 2021/8/8
 * @description druid config
 * */
@Configuration
public class DruidConfig {

    @ConfigurationProperties(prefix = "spring.datasource.druid")
    @Bean("myDruidDataSource")
    @Scope("prototype")
    public DruidDataSource myDruidDataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        // 数据库错误后重连的时间：1h
        druidDataSource.setTimeBetweenConnectErrorMillis(3600000);
        return druidDataSource;
    }

    @Bean
    public ServletRegistrationBean<StatViewServlet> statViewServlet() {
        ServletRegistrationBean<StatViewServlet> bean =
                new ServletRegistrationBean<>(new StatViewServlet(),"/druid/*");
        //后台需要有人登陆，账号密码配置
        Map<String, String> initParameters = new HashMap<>(3);
        //设置初始化参数，登陆key是固定的loginUsername loginPassword
        initParameters.put("loginUsername", "xy");
        initParameters.put("loginPassword", "sdb3309");
        /*允许谁可以访问
        禁止谁能访问：initParameters.put("sdb3309", "localhost");*/
        initParameters.put("allow", "");
        bean.setInitParameters(initParameters);
        return bean;
    }

}