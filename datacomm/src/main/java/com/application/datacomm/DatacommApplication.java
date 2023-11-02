package com.application.datacomm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class DatacommApplication {

    public static void main(String[] args) {
        SpringApplication.run(DatacommApplication.class, args);
    }

    // @Bean
    // public RestTemplate restTemplate() {
    //     return new RestTemplate();
    // }
}

