package com.dependentlearners.tools.turbine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.turbine.EnableTurbine;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication(scanBasePackages = "com.dependentlearners.tools.turbine")
@EnableDiscoveryClient
@EnableTurbine
public class TurbineAggregatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(TurbineAggregatorApplication.class, args);
    }
}
