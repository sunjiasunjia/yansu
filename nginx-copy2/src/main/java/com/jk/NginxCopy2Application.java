package com.jk;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication

@MapperScan("com.jk.mapper")
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 10)
public class NginxCopy2Application {

    public static void main(String[] args) {
        SpringApplication.run(NginxCopy2Application.class, args);
    }

    /**
     * 设置匹配.do后缀的请求
     * @param dispatcherServlet
     * @return
     */
    @Bean
    public ServletRegistrationBean servletRegistrationBean(DispatcherServlet dispatcherServlet) {
        ServletRegistrationBean bean = new ServletRegistrationBean(dispatcherServlet);
        bean.addUrlMappings("*.do");
        bean.addUrlMappings("*.js");
        bean.addUrlMappings("*.css");
        bean.addUrlMappings("*.png");
        bean.addUrlMappings("*.jpg");
        return bean;
    }


}

