package com.cloudlibrary.board.infrastructure.configuration;

import feign.Client;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

public class FeignClientConfiguration {

    @Bean
    @Scope("prototype")
    public Client feignClient(){
        return new Client.Default(null, null);
    }
}
