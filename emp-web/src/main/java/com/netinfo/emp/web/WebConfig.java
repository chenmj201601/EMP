package com.netinfo.emp.web;

import com.netinfo.emp.web.interceptor.LangInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Project emp-web
 * Package com.netinfo.emp.web
 * <p>
 * Created by Charley on 2017/3/15.
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
    /*
    注意:这个Bean需要在AddInterceptor之前实例化，不然Interceptor中AutoWired可以无效
     */
    @Bean
    public LangInterceptor getLangInterceptor() {
        return new LangInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getLangInterceptor());
        super.addInterceptors(registry);
    }
}
