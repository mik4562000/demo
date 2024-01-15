package com.example.demo.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.Locale;

public class TranslationInterceptor implements HandlerInterceptor {
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        LocaleContextHolder.resetLocaleContext();
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String language = request.getParameter("lang");
        Locale locale;
        if (language != null && !language.isEmpty()) {
            locale = Locale.forLanguageTag(language);
        } else {
            locale = Locale.ENGLISH;
        }
        LocaleContextHolder.setLocale(locale);
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }
}
