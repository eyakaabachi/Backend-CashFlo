package com.stage.proxym;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class ProxymApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProxymApplication.class, args);
    }

}
