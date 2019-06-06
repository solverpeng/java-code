package com.solverpeng.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootLoggingApplicationTests {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    public void contextLoads() {
        // 修改日志级别为trace后
        logger.trace("打印trace...");
        logger.debug("打印debug...");
        // springboot默认使用的是info级别的日志。
        logger.info("打印info...");
        logger.warn("打印warn...");
        logger.error("打印error...");
    }

}
