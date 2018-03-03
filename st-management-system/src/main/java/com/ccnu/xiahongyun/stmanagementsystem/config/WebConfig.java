package com.ccnu.xiahongyun.stmanagementsystem.config;

import com.ccnu.xiahongyun.stmanagementsystem.interceptor.verification.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.lang.reflect.InvocationHandler;

@Configuration
@ComponentScan
public class WebConfig extends WebMvcConfigurerAdapter{

    private final LoginInterceptor loginInterceptor;

    @Autowired
    public WebConfig(LoginInterceptor loginInterceptor){
        this.loginInterceptor = loginInterceptor;
    }
    /**
     * 设置首页
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.setOrder( Ordered.HIGHEST_PRECEDENCE );
        super.addViewControllers(registry);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(this.loginInterceptor)
                .addPathPatterns("/classroom/**")
                .addPathPatterns("/student/**")
                .addPathPatterns("/teacher/**")
                .addPathPatterns("/examroom/**")
                .addPathPatterns("/subject/**");
        super.addInterceptors(registry);
    }

}
