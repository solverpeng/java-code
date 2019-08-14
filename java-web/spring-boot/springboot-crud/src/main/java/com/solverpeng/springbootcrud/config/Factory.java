package com.solverpeng.springbootcrud.config;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

public class Factory {

    public static LocaleResolver createLocalResolver() {
        return new LocaleResolver(){

            @Override
            public Locale resolveLocale(HttpServletRequest request) {
                String language = request.getParameter("l");
                Locale locale = Locale.getDefault();
                if (!StringUtils.isEmpty(language)) {
                    String[] languageCountry = language.split("_");
                    locale = new Locale(languageCountry[0], languageCountry[1]);
                }
                return locale;
            }

            @Override
            public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

            }
        };
    }
}
