package org.sage42.devfest.e.test;

import android.view.View;

import com.jayway.android.robotium.solo.Solo;

public class JobBidTest extends ASimpleJobTest
{
    public void testBid()
    {
        final Solo solo = this.getSolo();

        // verify the job is displayed
        this.verifyJobIsDisplayed(this.mJob);

        // bid for job
        this.bidForJob();

        // verify toast appears
        assertTrue(solo.waitForText("accepted", 1, BID_ANIMATION_TIMEOUT)); //$NON-NLS-1$

        // verify job is gone
        assertFalse(solo.searchText(this.mJob.pickUp, true));
        assertFalse(solo.searchText(this.mJob.dropOff, true));

        // verify bid bar is shown
        this.verifyPendingBidsBarIsVisible();
    }

    public void testBidThenCancel()
    {
        final Solo solo = this.getSolo();

        // verify the job is displayed
        this.verifyJobIsDisplayed(this.mJob);

        // bid for job
        this.bidForJob();

        // verify toast appears
        assertTrue(solo.waitForText("accepted", 1, BID_ANIMATION_TIMEOUT)); //$NON-NLS-1$

        // verify job is gone
        assertFalse(solo.searchText(this.mJob.pickUp, true));
        assertFalse(solo.searchText(this.mJob.dropOff, true));

        // verify bid bar is shown
        this.verifyPendingBidsBarIsVisible();

        // click pending bid bar
        // using fake id instead of R.id.something
        final View bar = solo.getView(1);
        solo.clickOnView(bar);
        solo.sleep(UI_WAIT_DELAY);

        // verify list is shown
        // using fake id instead of R.id.something
        final View pendingList = solo.getView(1);
        assertNotNull(pendingList);
        assertEquals(View.VISIBLE, pendingList.getVisibility());

        // verify list content
        // using fake id instead of R.id.something
        solo.clickOnText(this.getContext().getString(1, this.mJob.distance));

        // confirm cancel bid is shown
        assertTrue(solo.searchText("CANCEL BID", true)); //$NON-NLS-1$

        // click cancel bid
        solo.clickOnText("CANCEL BID"); //$NON-NLS-1$
        solo.sleep(UI_WAIT_DELAY);

        // ensure the pending bar is gone
        assertEquals(View.GONE, pendingList.getVisibility());
    }

}
