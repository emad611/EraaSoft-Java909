package com.spring.demo.Service.helper;

import com.spring.demo.helpers.BundleErrorMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class BundleMessageService {
    private static ResourceBundleMessageSource messageSource;
    @Autowired
    public BundleMessageService(ResourceBundleMessageSource messageSource) {
        this.messageSource = messageSource;
    }
    public  String getMessageAr(String code){
        return messageSource.getMessage(code,null,new Locale("ar"));
    }
    public  String getMessageEn(String code){
        return messageSource.getMessage(code,null,new Locale("en"));
    }
    public  BundleErrorMessage getBundleMessage(String code){
        return new BundleErrorMessage(
                getMessageAr(code),
                getMessageEn(code)
        );
    }
    public static String getMessage(String code){
        return messageSource.getMessage(code, null, LocaleContextHolder.getLocale());
    }
}
