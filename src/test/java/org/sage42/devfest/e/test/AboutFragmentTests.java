package org.sage42.devfest.e.test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.shadows.ShadowActivity;
import org.robolectric.shadows.ShadowIntent;
import org.sage42.devfest.d.test.CustomRobolectricTestRunner;
import org.sage42.devfest.e.main.AboutFragment;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;

/**
 * A collection of test that verify the "links" from this fragment to outside services
 *
 */
@RunWith(CustomRobolectricTestRunner.class)
public class AboutFragmentTests
{
    // fake id to deal with the lack of R.java
    private static final int FAKE_ID = 0;
    
    private FragmentActivity mActivity;
    private ShadowActivity   mShadowActivty;
    private AboutFragment    mFragment;

    @Test
    public void testClickPhoneShowsDialer()
    {
        this.testClickSomethingShowSomething(FAKE_ID, Intent.ACTION_DIAL, "tel:"); //$NON-NLS-1$
    }

    @Test
    public void testClickEmailShowsEmail()
    {
        this.testClickSomethingShowSomething(FAKE_ID, Intent.ACTION_VIEW, "mailto:"); //$NON-NLS-1$
    }

    private void testClickSomethingShowSomething(final int clickTargetResId, final String resultantIntent,
                    final String dataPattern)
    {
        // click something
        final View clickTarget = this.mFragment.findViewById(clickTargetResId);
        assertThat(clickTarget, not(nullValue()));
        assertTrue(clickTarget.performClick());

        // check the resultant intent
        final Intent startedIntent = this.mShadowActivty.getNextStartedActivity();
        final ShadowIntent shadowIntent = Robolectric.shadowOf(startedIntent);
        assertThat(shadowIntent.getAction(), is(resultantIntent));

        if (dataPattern != null)
        {
            assertThat(shadowIntent.getData().toString(), containsString(dataPattern));
        }
    }

    @Before
    public void setUp() throws Exception
    {
        // create activity to hold the fragment
        this.mActivity = CustomRobolectricTestRunner.getActivity();

        // create and start the fragment
        this.mFragment = new AboutFragment();
        CustomRobolectricTestRunner.startFragment(this.mActivity, this.mFragment);

        // get link to shadow activity so we can verify stuff
        this.mShadowActivty = Robolectric.shadowOf(this.mActivity);
    }

}
