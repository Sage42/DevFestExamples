package org.sage42.devfest.e.test.utils;

import java.util.Calendar;
import java.util.Random;

import org.sage42.devfest.e.main.Job;

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
        final Calendar now = Calendar.getInstance();
        final Calendar surface = Calendar.getInstance();
        surface.add(Calendar.SECOND, 5);
        final Calendar close = Calendar.getInstance();
        close.add(Calendar.SECOND, 15);
        final Calendar confirm = Calendar.getInstance();
        confirm.add(Calendar.SECOND, 20);

        final Job output = new Job();

        output.bookingId = System.currentTimeMillis();
        output.pickUp = "p" + rand; //$NON-NLS-1$
        output.dropOff = "d" + rand; //$NON-NLS-1$
        output.jobTime = now.getTimeInMillis();
        output.remarks = "insert earth shattering remark here " + rand; //$NON-NLS-1$
        output.pickUpLat = 3.15538d;
        output.pickUpLng = 101.716104d;
        output.dropOffLat = 3.15538d;
        output.dropOffLng = 101.716104d;
        output.surfaceTime = surface.getTimeInMillis();
        output.closeTime = close.getTimeInMillis();
        output.confirmTime = confirm.getTimeInMillis();
        output.source = "source " + rand; //$NON-NLS-1$
        output.name = "customer " + rand; //$NON-NLS-1$
        output.phone = "phone " + rand; //$NON-NLS-1$
        output.fareLower = 12.34d;
        output.fareUpper = 34.56d;
        output.tip = 12d;
        output.commission = 0.56d;
        output.distance = 23.45d;
        output.immediate = 1;
        output.tags = "random|tags"; //$NON-NLS-1$
        return output;
    }
}
