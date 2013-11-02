package org.sage42.devfest.d.main;

import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

public class EventTable
{
    public static final String  TABLE_NAME          = EventTable.class.getSimpleName();

    public static final String  COLUMN_TEXT         = "content";                       //$NON-NLS-1$
    public static final String  COLUMN_TITLE        = "title";                         //$NON-NLS-1$
    public static final String  COLUMN_IMAGE        = "image";                         //$NON-NLS-1$
    public static final String  COLUMN_LINK         = "link";                          //$NON-NLS-1$
    public static final String  COLUMN_RESOURCE_URI = "resourceUri";                   //$NON-NLS-1$

    public static void onCreate(final SQLiteDatabase database)
    {
        final StringBuilder builder = new StringBuilder();
        builder.append("create table ").append(EventTable.TABLE_NAME); //$NON-NLS-1$
        builder.append(" (").append(BaseColumns._ID).append(" integer primary key autoincrement, "); //$NON-NLS-1$ //$NON-NLS-2$
        builder.append(EventTable.COLUMN_TEXT).append(" text,"); //$NON-NLS-1$
        builder.append(EventTable.COLUMN_TITLE).append(" text,"); //$NON-NLS-1$
        builder.append(EventTable.COLUMN_IMAGE).append(" text,"); //$NON-NLS-1$
        builder.append(EventTable.COLUMN_LINK).append(" text,"); //$NON-NLS-1$
        builder.append(EventTable.COLUMN_RESOURCE_URI).append(" text)"); //$NON-NLS-1$
        database.execSQL(builder.toString());

        // create indexes
        database.execSQL("Create Index " + EventTable.TABLE_NAME + "_" + EventTable.COLUMN_RESOURCE_URI + "_idx ON " + EventTable.TABLE_NAME + "(" + EventTable.COLUMN_RESOURCE_URI + ");"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$     
    }

    public static void onUpgrade(final SQLiteDatabase database, final int oldVersion, final int newVersion)
    {
        database.execSQL("DROP TABLE IF EXISTS " + EventTable.TABLE_NAME); //$NON-NLS-1$
        EventTable.onCreate(database);
    }

    public static String[] getProjection()
    {
        return new String[]
        { BaseColumns._ID, EventTable.COLUMN_TEXT, EventTable.COLUMN_TITLE, EventTable.COLUMN_IMAGE,
                        EventTable.COLUMN_LINK, EventTable.COLUMN_RESOURCE_URI };
    }

}
