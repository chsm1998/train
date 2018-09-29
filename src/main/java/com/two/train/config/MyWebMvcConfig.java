package com.two.train.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @program: pokemon
 * @author: chsm
 * @create: 2018-08-12 12:21
 **/
@Configuration
public class MyWebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE")
                .maxAge(3600)
                .allowCredentials(true);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 添加前台登录拦截器
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/*/front/**")
                .excludePathPatterns("/error", "/swagger-resources/**", "/webjars/**", "/v2/**", "/swagger-ui.html/**");
        // 添加后台登录拦截器
        registry.addInterceptor(new ManagerInterceptor())
                .addPathPatterns("/*/after/**")
                .excludePathPatterns("/manager/**", "/error", "/swagger-resources/**", "/webjars/**", "/v2/**", "/swagger-ui.html/**");
    }

}
