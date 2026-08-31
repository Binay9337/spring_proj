package com.jt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class Greet {
    private Greeting greeting;

    public Greet() {
        System.out.println("greet object is constructed");

    }

    @Autowired
    public void setGreeting(Greeting greeting) {
        System.out.println("greeting object is created");
        this.greeting = greeting;
    }

    public void greet() {
        System.out.println("hello EveryOne");
        // greeting.sayHi();
    }

    @PostConstruct
    public void init() {
        System.out.println("bean is initialized");
    }

    @PreDestroy // ========>>>>> this is to see before destroy do some operation
    public void Destroy() {
        System.out.println("Greet bean is destroyed");
    }
}
