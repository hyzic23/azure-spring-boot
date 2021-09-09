package com.imodeng;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info=@Info(title="Azure with Spring Boot API", version = "2.0", description = "Spring Boot Azure"))

public class AzureSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(AzureSpringBootApplication.class, args);
    }

}
