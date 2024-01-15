package com.example.demo;

import com.example.demo.interceptor.TranslationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    @Bean
    public ResourceBundleMessageSource translationSource(){
        final List<String> additionalBundles = List.of("translations");//AAAA
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        String[] bundlesArray = additionalBundles.toArray(new String[0]);
        messageSource.setBasenames(bundlesArray);
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new TranslationInterceptor());
    }
}
