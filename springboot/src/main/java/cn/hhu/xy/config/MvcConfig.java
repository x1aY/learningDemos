package cn.hhu.xy.config;

import org.springframework.boot.web.servlet.view.MustacheViewResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Locale;

/**
 * @author cn.hhu.xy
 * @date 2021/8/7
 * @description springMVC config
 * */
@Configuration
public class MvcConfig implements WebMvcConfigurer {

    /*
     * 定制化功能
     * */

    /*
    @Bean
    public ViewResolver myViewResolver(){
        return new MyViewResolver();
    }

    public static class MyViewResolver implements ViewResolver{
        @Override
        public View resolveViewName(String viewName, Locale locale) throws Exception {
            return null;
        }
    }
    */

    /*
    * 跳转
    * */
    /*
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("cn.hhu.xy").setViewName("404");
    }
    */



}
