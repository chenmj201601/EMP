package com.netinfo.emp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EmpServiceManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmpServiceManagerApplication.class, args);
    }
}
