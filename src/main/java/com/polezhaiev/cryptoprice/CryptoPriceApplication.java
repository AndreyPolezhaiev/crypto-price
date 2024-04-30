package com.polezhaiev.cryptoprice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class CryptoPriceApplication {
    public static void main(String[] args) {
        SpringApplication.run(CryptoPriceApplication.class, args);
    }
}
