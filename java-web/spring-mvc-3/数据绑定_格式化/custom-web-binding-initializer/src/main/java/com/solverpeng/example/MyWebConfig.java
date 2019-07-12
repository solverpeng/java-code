package com.solverpeng.example;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.support.ConfigurableWebBindingInitializer;
import org.springframework.web.servlet.config.annotation.DelegatingWebMvcConfiguration;

import java.text.SimpleDateFormat;
import java.util.Date;

@ComponentScan
public class MyWebConfig extends DelegatingWebMvcConfiguration {

    @Override
    protected ConfigurableWebBindingInitializer getConfigurableWebBindingInitializer() {
        ConfigurableWebBindingInitializer initializer = super.getConfigurableWebBindingInitializer();
        initializer.setPropertyEditorRegistrar(propertyEditorRegistry -> {
            SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
            propertyEditorRegistry.registerCustomEditor(Date.class,
                    new CustomDateEditor(dateFormatter, true));
        });
        return initializer;
    }
}
