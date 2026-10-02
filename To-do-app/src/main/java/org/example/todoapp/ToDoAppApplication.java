package org.example.todoapp;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@RequiredArgsConstructor
public class ToDoAppApplication {

    private final TodoService todoService;

    public static void main(String[] args) {
        SpringApplication.run(ToDoAppApplication.class, args);
    }


    }

