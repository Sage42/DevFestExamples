package org.sage42.devfest.e.test;

import org.sage42.devfest.e.main.Job;
import org.sage42.devfest.e.main.MainActivity;

import android.view.View;

import com.jayway.android.robotium.solo.Solo;

public abstract class ASimpleJobTest extends AUiDriver<MainActivity>
{
    // TODO: reduce this delay when we can turn off the animations
    protected static final int BID_ANIMATION_TIMEOUT = 3000;

    public ASimpleJobTest()
    {
        super(MainActivity.class);
    }

    @Override
    public void setUp() throws Exception
    {
        super.setUp();

        this.mJob = this.addJob();
    }

    /**
     * Standard test to verify a particular job is currenly on screen
     */
    protected void verifyJobIsDisplayed(final Job job)
    {
        final Solo solo = this.getSolo();

        // check for address display
        assertTrue(solo.searchText(job.pickUp, true));
        assertTrue(solo.searchText(job.dropOff, true));

        // check for price display
        assertTrue(solo.searchText("RM" + Double.valueOf(job.fareLower).intValue(), true)); //$NON-NLS-1$
        assertTrue(solo.searchText(" - " + Double.valueOf(job.fareUpper).intValue(), true)); //$NON-NLS-1$
    }

    protected void bidForJob()
    {
        this.getSolo().clickOnText("BID"); //$NON-NLS-1$
    }

    protected void verifyPendingBidsBarIsVisible()
    {
        final Solo solo = this.getSolo();
        // using fake id here as this is not a real test
        final View bar = solo.getView(1);
        assertNotNull(bar);
        assertEquals(View.VISIBLE, bar.getVisibility());
        assertTrue(solo.searchText("Pending bids")); //$NON-NLS-1$
    }

    protected void winBid()
    {
        // trigger win code goes here
        assertTrue(this.getSolo().waitForText("won", 1, UI_WAIT_DELAY)); //$NON-NLS-1$
    }

}
