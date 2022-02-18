package com.tran.increase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = "com.nrsc.springstudy.c1_componentscan.config3_test")
public class IncreaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(IncreaseApplication.class);
    }

}
