package com.cycling;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import springfox.documentation.oas.annotations.EnableOpenApi;

/**
 * @author xpdxz
 */
@SpringBootApplication
@EnableOpenApi
@MapperScan(basePackages = "com.cycling.dao")
public class CyclingSsmApplication {

    public static void main(String[] args) {
        SpringApplication.run(CyclingSsmApplication.class, args);
    }

}
