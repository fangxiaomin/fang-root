package com.fang;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableAdminServer   //来启用admin-server功能：
@SpringBootApplication
@EnableDiscoveryClient
public class FangAdminServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(FangAdminServerApplication.class, args);
    }

}
