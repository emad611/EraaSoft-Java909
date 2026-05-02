package com.spring.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import java.util.Locale;

@Configuration
public class BundleMessageConfig {
    @Value("${spring.messages.basename}")
    public String baseName;
    @Bean
    public ResourceBundleMessageSource messageSource(){
        ResourceBundleMessageSource source=new ResourceBundleMessageSource();
        source.setBasename(baseName);
        source.setDefaultEncoding("UTF-8");
        return source;
    }
    @Bean
    public AcceptHeaderLocaleResolver resolver(){
        AcceptHeaderLocaleResolver resolver=new AcceptHeaderLocaleResolver();
        resolver.setDefaultLocale(Locale.ENGLISH);
        return resolver;
    }
}
