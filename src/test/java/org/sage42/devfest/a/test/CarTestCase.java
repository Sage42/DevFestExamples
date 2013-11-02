package org.sage42.devfest.a.test;

import junit.framework.TestCase;

import org.sage42.devfest.a.main.Car;


public class CarTestCase extends TestCase
{
    public void testShouldStartThenAccelerate()
    {
        // create a test engine
        TestEngine engine = new TestEngine();
        
        // use Dependency Injection to inject the engine in the car
        Car car = new Car(engine);
        
        // drive the car
        car.drive();
        
        // check the outcome
        assertTrue(engine.isWasDriven());
    }
}
