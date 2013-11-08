package org.sage42.devfest.f.test;

import com.jayway.android.robotium.solo.Solo;

public class JobBidTest extends AbstractSimpleJobTest
{
    /**
     * Given that a job is displayed
     * When the user clicks "bid"
     * Then the job ad should disappear, they should 
     * see a notification and the pending bids counter should appear
     */
    public void testBid()
    {
        final Solo solo = this.getSolo();

        // Pre-condition: verify the job is displayed
        this.verifyJobIsDisplayed(this.mJob);

        // Action: bid for job
        this.bidForJob();

        // Verify: toast appears
        assertTrue(solo.waitForText("accepted", 1, BID_ANIMATION_TIMEOUT)); //$NON-NLS-1$

        // Verify: job is gone
        assertFalse(solo.searchText(this.mJob.pickUp, true));
        assertFalse(solo.searchText(this.mJob.dropOff, true));

        // Verify: bid bar is shown
        this.verifyPendingBidsBarIsVisible();
    }

}
