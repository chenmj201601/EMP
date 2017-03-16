package com.netinfo.emp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@EnableDiscoveryClient
@Controller
public class EmpCoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmpCoreApplication.class, args);
    }

    @RequestMapping("/")
    @ResponseBody
    public String hello() {
        return "Hello eMP-Core !";
    }
}
