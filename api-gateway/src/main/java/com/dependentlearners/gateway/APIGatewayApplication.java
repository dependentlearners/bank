package com.dependentlearners.gateway;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.cloud.sleuth.zipkin.ZipkinSpanReporter;
import org.springframework.context.annotation.Bean;
import zipkin.Span;

@EnableDiscoveryClient
@EnableZuulProxy
@SpringBootApplication(scanBasePackages = "com.dependentlearners")
public class APIGatewayApplication {

    private static final Log logger = LogFactory.getLog(APIGatewayApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(APIGatewayApplication.class, args);
    }
}
