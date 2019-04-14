package com.xmgl.blog.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author 张富华
 * @date 2019/1/29
 */
@Configuration
public class MvcConfiguration implements WebMvcConfigurer {

//    @Value("${win.photo.img.path}")
//    private String photoPath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/photo/**").addResourceLocations(photoPath);
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/templates/**").addResourceLocations("classpath:/templates/");
    }
}