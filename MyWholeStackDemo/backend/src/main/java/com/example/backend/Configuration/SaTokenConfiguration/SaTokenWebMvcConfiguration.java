package com.example.backend.Configuration.SaTokenConfiguration;

import cn.dev33.satoken.interceptor.SaRouteInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SaTokenWebMvcConfiguration implements WebMvcConfigurer {

    @Autowired
    private SaTokenUrlConfiguration saTokenUrlConfig;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册1个登录认证拦截器
        registry.addInterceptor(new SaRouteInterceptor())
                .addPathPatterns(this.saTokenUrlConfig.getInterceptUrlList())
                .excludePathPatterns(this.saTokenUrlConfig.getOpenUrlList());
    }

}
