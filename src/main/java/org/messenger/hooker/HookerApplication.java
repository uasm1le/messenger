package org.messenger.hooker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication

@EnableWebMvc
public class HookerApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(HookerApplication.class, args);


    }

}
