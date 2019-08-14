package com.solverpeng.spring.boot.autoconfigure;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = MessageProperties.MESSAGE_PREFIX)
@Data
public class MessageProperties {

    public static final String MESSAGE_PREFIX = "message";

    /**
     * URL地址
     */
    private String url;
    /**
     * APP ID
     */
    private String appId;
    /**
     * 密钥
     */
    private String appSecret;


    /**
     * Rest 模板
     */
    private RestTemplate restTemplate;

    @Data
    public static class RestTemplate {

        /**
         * 客户端名称
         */
        private String clientName;
    }
}
