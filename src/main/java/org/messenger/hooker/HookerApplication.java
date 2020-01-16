package org.messenger.hooker;

import lombok.var;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication

@EnableWebMvc
@ComponentScan
public class HookerApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(HookerApplication.class, args);


    }

}
