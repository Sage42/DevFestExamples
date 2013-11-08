package org.sage42.devfest.f.test.utils;

import java.util.Random;

import org.sage42.devfest.f.main.Job;

public class TestJobBuilder
{
    private TestJobBuilder()
    {
        // enforce singleton
        super();
    }

    public static Job buildJob()
    {
        // seed info to make it random
        final String rand = String.valueOf(new Random().nextInt(99999));
        final Job output = new Job();

        output.bookingId = System.currentTimeMillis();
        output.pickUp = "pickup " + rand; //$NON-NLS-1$
        output.dropOff = "dropOff " + rand; //$NON-NLS-1$
        output.name = "customer " + rand; //$NON-NLS-1$
        output.phone = "phone " + rand; //$NON-NLS-1$
        return output;
    }
}
