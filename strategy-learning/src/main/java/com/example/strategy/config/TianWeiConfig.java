package com.example.strategy.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TianWeiConfig {

    @Value("${tianwei.config-path}")
    private String configPath;

    @Bean
    public void tencenTianWeiConfigPath(){
        System.out.println(configPath);

        //do something
    }
}
