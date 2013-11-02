package org.sage42.devfest.d.main;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * 
 */
public class DbHelper extends SQLiteOpenHelper
{
    private static final String DATABASE_NAME    = "test.db"; //$NON-NLS-1$
    private static final int    DATABASE_VERSION = 1;
    private static DbHelper     INSTANCE;

    private DbHelper(final Context context)
    {
        super(context, DbHelper.DATABASE_NAME, null, DbHelper.DATABASE_VERSION);
    }

    public static synchronized DbHelper getInstance(final Context context)
    {
        if (DbHelper.INSTANCE == null)
        {
            DbHelper.INSTANCE = new DbHelper(context.getApplicationContext());
        }

        return DbHelper.INSTANCE;
    }

    @Override
    public void onCreate(final SQLiteDatabase database)
    {
        EventTable.onCreate(database);
    }

    @Override
    public void onUpgrade(final SQLiteDatabase database, final int oldVersion, final int newVersion)
    {
        EventTable.onUpgrade(database, oldVersion, newVersion);
    }

}
