package com.cloudlibrary.board;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableFeignClients
@EnableJpaAuditing
@EnableWebMvc
@SpringBootApplication
public class BoardApplication {

    public static void main(String[] args) {
        SpringApplication.run(BoardApplication.class, args);
    }

}
