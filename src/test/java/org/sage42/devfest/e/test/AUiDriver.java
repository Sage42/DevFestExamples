package org.sage42.devfest.e.test;

import java.util.Calendar;

import org.sage42.devfest.e.main.Job;
import org.sage42.devfest.e.test.utils.ARobotiumBase;
import org.sage42.devfest.e.test.utils.TestJobBuilder;

import android.app.Activity;
import android.content.Intent;

import com.jayway.android.robotium.solo.Solo;

public abstract class AUiDriver<ActivityUnderTest extends Activity> extends ARobotiumBase<ActivityUnderTest>
{
    public static final long BOOKING_ID        = 314159l;

    public static final int  DEFAULT_WAIT_TIME = 600;

    protected Job            mJob;

    public AUiDriver(final Class<ActivityUnderTest> activityClass)
    {
        super(activityClass);

        final Intent intent = new Intent();
        intent.putExtra("mBookingId", BOOKING_ID); //$NON-NLS-1$
        this.setActivityIntent(intent);
    }

    /**
     * Create a test job notification (immediate display)
     * This will post to the event bus and save the job into the db
     * 
     * @return
     */
    protected Job addJob()
    {
        return this.addJob(BOOKING_ID);
    }

    protected Job addJob(final long bookingId)
    {
        final Job newJob = TestJobBuilder.buildJob();
        newJob.surfaceTime = Calendar.getInstance().getTimeInMillis();
        newJob.bookingId = bookingId;

        // insert a job ad
        return newJob;
    }

    protected void verifyPickUpDisplay()
    {
        //  verify display of pick up displayed (should have customer, pick up add and the words "PICK UP"
        final Solo solo = this.getSolo();
        assertTrue(solo.searchText(this.mJob.name, true));
        assertTrue(solo.searchText(this.mJob.pickUp, true));
        assertTrue(solo.searchText("PICK UP", true)); //$NON-NLS-1$
    }
}
