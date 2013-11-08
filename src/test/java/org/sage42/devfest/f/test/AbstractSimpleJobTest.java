package org.sage42.devfest.f.test;

import org.sage42.devfest.f.main.Job;
import org.sage42.devfest.f.main.MainActivity;

import android.view.View;

import com.jayway.android.robotium.solo.Solo;

public abstract class AbstractSimpleJobTest extends AbstractUiDriver<MainActivity>
{
    protected static final int BID_ANIMATION_TIMEOUT = 3000;

    public AbstractSimpleJobTest()
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
     * Standard test to verify a particular job is currently on screen
     */
    protected void verifyJobIsDisplayed(final Job job)
    {
        final Solo solo = this.getSolo();

        // check for address display
        assertTrue(solo.searchText(job.pickUp, true));
        assertTrue(solo.searchText(job.dropOff, true));
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

}
