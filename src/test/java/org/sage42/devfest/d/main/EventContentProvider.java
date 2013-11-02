package org.sage42.devfest.d.main;

import android.net.Uri;

public class EventContentProvider extends ABaseContentProvider
{
    public static final String AUTHORITY   = EventContentProvider.class.getCanonicalName();
    public static final Uri    CONTENT_URI = Uri.parse("content://" + EventContentProvider.AUTHORITY + "/" + EventTable.TABLE_NAME); //$NON-NLS-1$//$NON-NLS-2$

    public EventContentProvider()
    {
        super(EventTable.TABLE_NAME);
    }

}
