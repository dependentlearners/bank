package com.dependentlearners.presentation.web.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.dependentlearners")
@RestController
@SpringBootApplication(scanBasePackages = "com.dependentlearners")
public class WebApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebApiApplication.class, args);
    }

    @RequestMapping("ping")
    public ResponseEntity<?> ping(){
        return new ResponseEntity<String>("Welcome To Web API", HttpStatus.OK);
    }
}

