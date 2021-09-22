package com.cycling;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

@SpringBootApplication
@EnableOpenApi
public class CyclingSsmApplication {

    public static void main(String[] args) {
        SpringApplication.run(CyclingSsmApplication.class, args);
    }

}
