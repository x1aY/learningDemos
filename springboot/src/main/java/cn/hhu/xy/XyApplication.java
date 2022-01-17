package cn.hhu.xy;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author cn.hhu.xy
 * @date 2021/8/6
 * @description for learning springboot
 * */
@SpringBootApplication(exclude = {DruidDataSourceAutoConfigure.class, DataSourceAutoConfiguration.class})
//@SpringBootApplication()
public class XyApplication {
    public static void main(String[] args) {
        SpringApplication.run(XyApplication.class, args);
    }
}
