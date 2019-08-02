package com.solverpeng.example;

import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.accept.ContentNegotiationStrategy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class MyController {
    @Autowired
    ApplicationContext context;

    @RequestMapping("/")
    @ResponseBody
    public String handleRequest () {
        Map<String, ContentNegotiationStrategy> map =
                BeanFactoryUtils.beansOfTypeIncludingAncestors(
                        context, ContentNegotiationStrategy.class,
                        true, false);

        map.forEach((k, v) -> System.out.printf("%s=%s%n",
                k, v.getClass().getSimpleName()));

        return "response";
    }

    @RequestMapping("/print")
    @ResponseBody
    public String handleRequest2 () {
        Map<String, ContentNegotiationStrategy> map =
                BeanFactoryUtils.beansOfTypeIncludingAncestors(
                        context, ContentNegotiationStrategy.class,
                        true, false);

        ContentNegotiationManager m = (ContentNegotiationManager) map.get("mvcContentNegotiationManager");
        List<ContentNegotiationStrategy> strategies = m.getStrategies();
        strategies.forEach(s-> System.out.println(s.getClass().getName()));

        return "response";
    }


}
