package com.solverpeng.controller;

import com.solverpeng.bean.Order;
import com.solverpeng.bean.Person;
import com.solverpeng.bean.Trade;
import com.solverpeng.bean.User;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.format.Formatter;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.format.number.NumberStyleFormatter;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.ServletRequestParameterPropertyValues;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.beans.PropertyEditor;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/dataBinder")
public class DataBinderController {

    @InitBinder("user")
    public void disAllowedUserName(WebDataBinder dataBinder) {
        // 不绑定"name"属性
        dataBinder.setDisallowedFields("name");
    }

    // 注册自定义编辑器
    @InitBinder("user")
    public void userBirthEditor(WebDataBinder dataBinder) {
        // 对日期类通过自定义编辑器进行格式化
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        dateFormatter.setLenient(false);
        PropertyEditor propertyEditor = new CustomDateEditor(dateFormatter, true);
        dataBinder.registerCustomEditor(Date.class, "dateOfBirth", propertyEditor);
    }

    @InitBinder("trade")
    public void formatter(WebDataBinder dataBinder) {
        DateFormatter dateFormatter = new DateFormatter();
        dateFormatter.setPattern("yyyy-MM-dd");
        dataBinder.addCustomFormatter(new Formatter<LocalDate>() {
            @Override
            public LocalDate parse(String text, Locale locale) throws ParseException {
                return LocalDate.parse(text, DateTimeFormatter.ISO_DATE);
            }

            @Override
            public String print(LocalDate date, Locale locale) {
                return DateTimeFormatter.ISO_DATE.format(date);
            }
        }, "tradeDate");

        NumberStyleFormatter numberFormatter = new NumberStyleFormatter("#,###,###,###.##");
        dataBinder.addCustomFormatter(numberFormatter, "amount");
    }


//    @InitBinder
    public void initBinder(WebDataBinder binder, HttpServletRequest request) {
        PropertyValues pvs = new ServletRequestParameterPropertyValues(request);
        binder.bind(pvs);
        binder.addCustomFormatter(null);
        binder.addValidators(null);
        binder.initBeanPropertyAccess();
        binder.setValidator(null);
        binder.setRequiredFields();
        binder.setConversionService(null);
        binder.setAllowedFields();
        binder.setDisallowedFields();
        binder.setBindingErrorProcessor(null);
        binder.setMessageCodesResolver(null);
        binder.replaceValidators();
        binder.registerCustomEditor(null, null, null);
        binder.convertIfNecessary(null, null);
    }

    @ResponseBody
    @GetMapping("/bindRequestParamToModelAttribute")
    public String bindRequestParamToModelAttribute(@ModelAttribute("user") User user, BindingResult result) {
        if(result.hasErrors()) {
            List<ObjectError> allErrors = result.getAllErrors();
            if(!CollectionUtils.isEmpty(allErrors)) {
                for(ObjectError allError : allErrors) {
                    System.out.println("error: " + allError.getDefaultMessage());
                }
            }
        }
        return "dataBinder->bindRequestParamToModelAttribute:" + user;
    }

    /**
     * 默认也会进行绑定
     */
    @ResponseBody
    @GetMapping("/dataBinderWithMethodArgs")
    public String DataBinderWithMethodArgs(@ModelAttribute("person") Person person) {
        return "dataBinderWithMethodArgs" + person;
    }

    @ResponseBody
    @GetMapping("/dataBindWithFormatter")
    public String dataBindWithFormatter(Trade trade, BindingResult result) {
        return "dataBindWithFormatter->trade:" + trade;
    }

    @ResponseBody
    @GetMapping("/dataBindWithAnnotationFormatter")
    public String dataBindWithAnnotationFormatter(Order order, BindingResult result) {
        return "dataBindWithFormatter->order:" + order;
    }

}
