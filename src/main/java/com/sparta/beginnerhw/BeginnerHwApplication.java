package com.sparta.beginnerhw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class BeginnerHwApplication {

    public static void main(String[] args) {
        SpringApplication.run(BeginnerHwApplication.class, args);
    }

}
