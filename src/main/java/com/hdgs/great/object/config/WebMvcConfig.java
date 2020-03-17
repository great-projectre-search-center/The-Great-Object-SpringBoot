package com.hdgs.great.object.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Value("${xyz.zxcwxy999.uploadedfilepath}")
    String uploadedfilepath;

    @Value("${xyz.zxcwxy999.resourcepath}")
    String resourcepath;

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/hello").setViewName("hello");
        registry.addViewController("/").setViewName("index");
//        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/test").setViewName("test");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/bookcover/**").addResourceLocations("file://"+resourcepath+"/bookcoverimg/");
        registry.addResourceHandler("/img/**").addResourceLocations("file://"+uploadedfilepath+"/img/");
        registry.addResourceHandler("/avatar/**").addResourceLocations("file://"+uploadedfilepath+"/avatar/");
        registry.addResourceHandler("/bgimg/**").addResourceLocations("file://"+resourcepath+"/bgimg/");
    }
}

