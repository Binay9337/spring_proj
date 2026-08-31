package com.jt;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("rahul")
@Primary
public class DieselEngine implements Engine {
    @Override
    public void startEngine() {
        // TODO Auto-generated method stub
        System.out.println("diesel engine started");

    }

    @Override
    public void stopEngine() {
        // TODO Auto-generated method stub
        System.out.println("diesel engine stopped");

    }
}
