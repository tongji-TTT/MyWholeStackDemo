package com.example.backend.Configuration.SaTokenConfiguration;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.List;


@Data
@Configuration
@PropertySource("classpath:application-dev.yml")
@ConfigurationProperties(prefix = "sa-token", ignoreUnknownFields = true)
public class SaTokenUrlConfiguration {

    /**
     * 拦截url
     */
    @Value("${interceptUrlList}")
    private List<String> interceptUrlList;

    /**
     * 开放url
     */
    @Value("${openUrlList}")
    private List<String> openUrlList;

}
