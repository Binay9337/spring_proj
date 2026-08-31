package com.jt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Car {

    /*
     * field injection
     * 
     * @Autowired
     * private Engine engine;
     */

    /*
     * setter injection
     * private Engine engine;
     * 
     * @Autowired
     * private void setEngine(Engine engine) {
     * this.engine = engine;
     * }
     */

    // if there are two constrcution then IOC will call non parameterized but so
    // here we have to call @Autowired but if is was one then no need of @Autowired
    private Engine engine;

    @Autowired
    public Car(@Qualifier("rahul") Engine engine) {
        this.engine = engine;
    }

    public Car() {
        System.out.println("non parameterized construction");
    }

    public void startCar() {
        // Engine engine = new Engine();
        engine.startEngine();
        System.out.println("car is started");
    }

    public void stopCar() {
        // Engine engine = new Engine();
        engine.stopEngine();
        System.out.println("car is stopped");
    }
}
