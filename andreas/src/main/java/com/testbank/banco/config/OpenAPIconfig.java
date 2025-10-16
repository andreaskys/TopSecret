package com.testbank.banco.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class OpenAPIconfig {

    @Bean
    OpenAPI customOpenAPI(){
        return new OpenAPI().info(new Info()
                .title("REST API's RESTful with Java, Spring Boot , kubernetes and Docker")
                .version("v1")
                .description("REST API's RESTful with Java, Spring Boot , kubernetes and Docker")
                .termsOfService("https://google.com")
                .license(new License().name("Apache 2.0").url("https://www.apache.org/licenses/LICENSE-2.0"))
        );
    }
}