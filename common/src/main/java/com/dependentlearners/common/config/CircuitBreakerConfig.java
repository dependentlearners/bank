package com.dependentlearners.common.config;

import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Configuration;

@EnableHystrix
@Configuration
public class CircuitBreakerConfig {
}
