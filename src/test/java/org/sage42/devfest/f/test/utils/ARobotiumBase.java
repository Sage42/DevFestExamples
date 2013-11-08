package org.sage42.devfest.f.test.utils;

import android.app.Activity;
import android.content.Context;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.EditText;

import com.jayway.android.robotium.solo.Solo;

/**
 */
public abstract class ARobotiumBase<ActivityUnderTest extends Activity> extends
                ActivityInstrumentationTestCase2<ActivityUnderTest>
{
    public static final int UI_WAIT_DELAY = 200;

    private Solo            mSolo;

    public ARobotiumBase(final Class<ActivityUnderTest> activityClass)
    {
        super(activityClass);
    }

    @Override
    public void setUp() throws Exception
    {
        // start up the activity
        final Activity activity = this.getActivity();
        this.mSolo = new Solo(this.getInstrumentation(), activity);

        super.setUp();

        // make sure the activity loaded
        assertTrue(this.getSolo().waitForActivity(activity.getClass().getSimpleName()));
    }

    @Override
    public void tearDown() throws Exception
    {
        super.tearDown();

        // close any dialogs
        this.mSolo.goBack();

        // close any activities
        this.mSolo.finishOpenedActivities();
    }

    /**
     * Click on a view with supplied resourceId
     * 
     * @param resId
     */
    protected void clickViewByResId(final int resId)
    {
        final Solo solo = this.mSolo;
        solo.clickOnView(solo.getCurrentActivity().findViewById(resId));
    }

    /**
     * Enter text into the specified EditText component
     * 
     * @return
     */
    public void enterText(final int resId, final String text)
    {
        this.mSolo.enterText((EditText) this.getActivity().findViewById(resId), text);
    }

    public Solo getSolo()
    {
        return this.mSolo;
    }

    public Context getContext()
    {
        return this.getInstrumentation().getTargetContext();
    }

}
