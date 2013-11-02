package org.sage42.devfest.d.test;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowContentResolver;
import org.sage42.devfest.d.main.Event;
import org.sage42.devfest.d.main.EventContentProvider;
import org.sage42.devfest.d.main.EventTable;

import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.BaseColumns;

@RunWith(CustomRobolectricTestRunner.class)
@Config(shadows =
{ CustomSQLiteShadow.class })
public class EventContentProviderTest
{
    private Activity             mContext;
    private EventContentProvider mProvider;
    private ContentResolver      mResolver;

    @Before
    public void setUp() throws Exception
    {
        this.mProvider = new EventContentProvider();
        this.mContext = Robolectric.buildActivity(Activity.class).create().start().resume().get();
        this.mResolver = this.mContext.getContentResolver();
        this.mProvider.onCreate();
        ShadowContentResolver.registerProvider(EventContentProvider.AUTHORITY, this.mProvider);
    }

    @Test
    public void testBasicCrud()
    {
        // create an event
        final Event event = new Event();
        event.setImage("/some/image/uri"); //$NON-NLS-1$
        event.setLink("/some/link"); //$NON-NLS-1$
        event.setResourceUri("/rest/uri/1"); //$NON-NLS-1$
        event.setText("this is a test object"); //$NON-NLS-1$

        // insert into the db
        final Uri uri = this.mResolver.insert(EventContentProvider.CONTENT_URI, event.toContentValues());

        // check if the correct uri is returned
        Assert.assertThat(uri,
                        CoreMatchers.is(Uri.withAppendedPath(EventContentProvider.CONTENT_URI, Long.toString(1))));

        // check if the data was inserted
        final Cursor cursorInserted = this.mResolver.query(EventContentProvider.CONTENT_URI, null, null, null, null);
        Assert.assertThat(cursorInserted, CoreMatchers.not(CoreMatchers.nullValue()));
        Assert.assertThat(cursorInserted.getCount(), CoreMatchers.is(1));
        cursorInserted.close();

        // update the record
        event.setImage("foobar"); //$NON-NLS-1$
        final int rowsUpdated = this.mResolver.update(EventContentProvider.CONTENT_URI, event.toContentValues(),
                        BaseColumns._ID + " = ? ", new String[] //$NON-NLS-1$
                        { String.valueOf(1) });
        Assert.assertThat(rowsUpdated, CoreMatchers.is(1));

        // check if the data was updated
        final Cursor cursorUpdated = this.mResolver.query(EventContentProvider.CONTENT_URI, EventTable.getProjection(),
                        null, null, null);
        Assert.assertThat(cursorUpdated, CoreMatchers.not(CoreMatchers.nullValue()));
        Assert.assertThat(cursorUpdated.getCount(), CoreMatchers.is(1));
        Assert.assertTrue(cursorUpdated.moveToFirst());
        Assert.assertThat(cursorUpdated.getString(cursorUpdated.getColumnIndexOrThrow(EventTable.COLUMN_IMAGE)),
                        CoreMatchers.is("foobar")); //$NON-NLS-1$
        cursorUpdated.close();

        // delete the record
        final int rowsDeleted = this.mResolver.delete(EventContentProvider.CONTENT_URI,
                        BaseColumns._ID + " = ? ", new String[] //$NON-NLS-1$
                        { String.valueOf(1) });
        Assert.assertThat(rowsDeleted, CoreMatchers.is(1));

        // make sure its gone
        final Cursor cursorDeleted = this.mResolver.query(EventContentProvider.CONTENT_URI, EventTable.getProjection(),
                        null, null, null);
        Assert.assertThat(cursorDeleted, CoreMatchers.not(CoreMatchers.nullValue()));
        Assert.assertThat(cursorDeleted.getCount(), CoreMatchers.is(0));
        cursorDeleted.close();
    }
}
