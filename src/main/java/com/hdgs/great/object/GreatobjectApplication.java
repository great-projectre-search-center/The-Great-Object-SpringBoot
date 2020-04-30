package com.hdgs.great.object;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.hdgs.great.object.repository")
public class GreatobjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(GreatobjectApplication.class, args);
    }

}
