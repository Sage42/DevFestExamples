package org.sage42.devfest.a.main;

public class Car
{
    private Engine mEngine;
    
    public Car(final Engine engine)
    {
        this.mEngine = engine;
    }
    
    public void drive()
    {
        this.mEngine.start();
        this.mEngine.accelerate();
    }
}
