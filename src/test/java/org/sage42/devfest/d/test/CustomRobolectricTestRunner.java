package org.sage42.devfest.d.test;

import org.junit.runners.model.InitializationError;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

public class CustomRobolectricTestRunner extends RobolectricTestRunner
{
    public CustomRobolectricTestRunner(final Class<?> testClass) throws InitializationError
    {
        super(testClass);
    }

    public static void startFragment(final Fragment fragment)
    {
        startFragment(getActivity(), fragment);
    }

    public static void startFragment(final FragmentActivity activity, final Fragment fragment)
    {
        final FragmentManager fragmentManager = activity.getSupportFragmentManager();
        final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(fragment, null);
        fragmentTransaction.commit();
    }

    public static FragmentActivity getActivity()
    {
        return Robolectric.buildActivity(FragmentActivity.class).create().resume().get();
    }

}
