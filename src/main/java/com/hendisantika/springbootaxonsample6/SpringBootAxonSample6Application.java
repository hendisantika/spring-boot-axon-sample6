package com.hendisantika.springbootaxonsample6;

import com.hendisantika.springbootaxonsample6.command.exception.ProductServiceEventsErrorHandler;
import org.axonframework.config.EventProcessingConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootAxonSample6Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootAxonSample6Application.class, args);
    }

    @Autowired
    public void configure(EventProcessingConfigurer configurer) {
        configurer.registerListenerInvocationErrorHandler(
                "product",
                configuration -> new ProductServiceEventsErrorHandler()
        );
    }
}
