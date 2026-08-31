package com.jt.hello;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration 
public class AppConfig {
    @Bean
    public Student student(){
        return new Student();
    }

    @Bean
    public CommandLineRunner commandLineRunner(){
        return el -> System.out.println("this method is called after ");
    }
}
