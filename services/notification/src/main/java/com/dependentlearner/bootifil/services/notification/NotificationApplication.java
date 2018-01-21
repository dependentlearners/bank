package com.dependentlearner.bootifil.services.notification;

import com.dependentlearner.bootifil.services.notification.service.INotificationService;
import com.dependentlearner.bootifil.services.notification.service.NotificationServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@EnableFeignClients(basePackages = "com.dependentlearners")
@EnableDiscoveryClient(autoRegister = false)
@SpringBootApplication(scanBasePackages = "com.dependentlearners")
public class NotificationApplication {

    public static void main(String[] args) {
        SpringApplication.run(NotificationApplication.class, args);
    }

    @Bean
    public INotificationService service(){
        return new NotificationServiceImpl();
    }
}

