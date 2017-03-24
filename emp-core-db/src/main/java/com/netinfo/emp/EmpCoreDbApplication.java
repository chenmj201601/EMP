package com.netinfo.emp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@EnableEurekaClient
@Controller
public class EmpCoreDbApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmpCoreDbApplication.class, args);
    }

    @RequestMapping("/")
    @ResponseBody
    public String hello() {
        return "Welcome eMP Core DB";
    }
}
