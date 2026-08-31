package com.jt;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class PetrolEngine implements Engine {
    @Override
    public void startEngine() {
        System.out.println("petrol engine started");
    }

    @Override
    public void stopEngine() {
        System.out.println("petrol engine started");

    }
}
