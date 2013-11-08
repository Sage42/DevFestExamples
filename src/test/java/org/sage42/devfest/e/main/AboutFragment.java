package org.sage42.devfest.e.main;

import android.content.pm.PackageManager.NameNotFoundException;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.widget.TextView;

public class AboutFragment extends Fragment
{
    private static final String TAG = AboutFragment.class.getSimpleName();

    // fake id because this isnt an android project
    private static final int FAKE_ID = 0;

    protected TextView          mVersion;

    protected void init()
    {
        // pull version name from manifest
        try
        {
            this.mVersion.setText(this.getActivity().getPackageManager()
                            .getPackageInfo(this.getActivity().getPackageName(), 0).versionName);
        }
        catch (final NameNotFoundException e)
        {
            // this should not happen
            Log.w(AboutFragment.TAG, e.getMessage(), e);
        }
    }

    void onClickCall()
    {
        IntentUtils.doCall(this.getActivity(), this.getString(FAKE_ID));
    }

    void onClickEmail()
    {
        IntentUtils.doEmail(this.getActivity(), this.getString(FAKE_ID));
    }

}