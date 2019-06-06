package com.solverpeng.springboot;

import com.solverpeng.springboot.bean.Person;
import com.solverpeng.springboot.service.HelloService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootConfigApplicationTests {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    Person person;

    @Autowired
    HelloService helloService;

    @Test
    public void contextLoads() {
        logger.trace("这是trace..测试");
        logger.debug("这是debug日志..");
        logger.info("这是info日志..");
        logger.warn("warn...");
        logger.error("error...");
    }


    @Test
    public void person() {
        System.out.println(person);
    }

}
