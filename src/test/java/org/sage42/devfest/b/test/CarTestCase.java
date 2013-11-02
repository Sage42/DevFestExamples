package org.sage42.devfest.b.test;

import junit.framework.TestCase;

import org.mockito.InOrder;
import org.mockito.Mockito;
import org.sage42.devfest.a.main.Car;
import org.sage42.devfest.a.main.Engine;


public class CarTestCase extends TestCase
{
    public void testShouldStartThenAccelerate()
    {
        // create a mock engine
        Engine mockEngine = Mockito.mock(Engine.class);
        
        // use Dependency Injection to inject the engine in the car
        Car car = new Car(mockEngine);
        
        // drive the car
        car.drive();
        
        // check the methods where called and in order
        InOrder inOrder = Mockito.inOrder(mockEngine);
        inOrder.verify(mockEngine, Mockito.times(1)).start();
        inOrder.verify(mockEngine, Mockito.times(1)).accelerate();
    }
    
}
