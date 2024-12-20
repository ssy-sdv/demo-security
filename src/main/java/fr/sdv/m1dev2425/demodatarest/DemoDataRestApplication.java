package fr.sdv.m1dev2425.demodatarest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class DemoDataRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoDataRestApplication.class, args);
    }

}
