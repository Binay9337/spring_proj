package com.jt;

import org.springframework.stereotype.Component;

/* @Component
public class Engine {
    public void startEngine() {
        System.out.println("engine is starting");
    }

    public void stopEngine() {
        System.err.println("Engine is stopping");
    }
}
 */

/**
 * Engine
 */
public interface Engine {
    void startEngine();

    void stopEngine();
}