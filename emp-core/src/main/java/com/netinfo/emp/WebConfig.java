package com.netinfo.emp;

import com.netinfo.emp.core.interceptor.ApiCheckInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Project emp-core
 * Package com.netinfo.emp
 * <p>
 * Created by Charley on 2017/3/23.
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
    @Bean
    public ApiCheckInterceptor getApiCheckInterceptor() {
        return new ApiCheckInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getApiCheckInterceptor());
        super.addInterceptors(registry);
    }
}
