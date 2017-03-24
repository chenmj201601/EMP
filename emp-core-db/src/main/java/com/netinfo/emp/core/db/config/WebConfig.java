package com.netinfo.emp.core.db.config;

import com.netinfo.emp.core.db.interceptor.ApiCheckInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Project emp-core-db
 * Package com.netinfo.emp.core.db.config
 * <p>
 * Created by Charley on 2017/3/22.
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
