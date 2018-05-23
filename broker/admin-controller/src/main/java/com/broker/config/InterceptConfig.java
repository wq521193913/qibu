package com.broker.config;

import com.broker.controller.intercept.ControllerIntercept;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author: Administrator
 * @description: qibu
 * @date: 2018/3/22 0022 14:36
 * @modified:
 */
@Configuration
public class InterceptConfig extends WebMvcConfigurerAdapter{

    @Bean
    public ControllerIntercept getControllerIntercept(){
        return new ControllerIntercept();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getControllerIntercept()).addPathPatterns("/**")
                .excludePathPatterns("/static/**","/login","/");
        super.addInterceptors(registry);
    }
}
