package org.sage42.devfest.a.test;

import org.sage42.devfest.a.main.Engine;

/**
 * Stub implementation of the Engine interface
 */
public class TestEngine implements Engine
{
    boolean mStartWasCalled      = false;
    boolean mAccelerateWasCalled = false;
    boolean mSequenceWasCorrect  = false;

    @Override
    public void start()
    {
        this.mStartWasCalled = true;
    }

    @Override
    public void accelerate()
    {
        this.mAccelerateWasCalled = true;
        if (this.mStartWasCalled)
        {
            this.mSequenceWasCorrect = true;
        }
    }

    public boolean isWasDriven()
    {
        return this.mStartWasCalled && this.mAccelerateWasCalled && this.mSequenceWasCorrect;
    }
}
