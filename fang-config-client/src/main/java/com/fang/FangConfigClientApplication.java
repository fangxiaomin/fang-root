package com.fang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class FangConfigClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(FangConfigClientApplication.class, args);
    }

}
