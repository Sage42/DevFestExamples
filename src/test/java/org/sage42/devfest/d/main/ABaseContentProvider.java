package org.sage42.devfest.d.main;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;

/**
 * Common/Default implementation of a ContentProvider backed by a SQLite db
 * 
 * NOTE: All methods clean up after themselves except {@link ABaseContentProvider#query(Uri, String[], String, String[], String)}
 * As there should be no error thrown by calling {@link ABaseContentProvider#close()} unnecessarily its recommended that you call this 
 * at the end of any lifecycle phase that uses this ContentProvider.
 *  
 */
public abstract class ABaseContentProvider extends ContentProvider
{
    // database connection
    private DbHelper     mDatabase;

    private final String mTableName;

    protected ABaseContentProvider(final String tableName)
    {
        super();
        this.mTableName = tableName;
    }

    @Override
    public synchronized boolean onCreate()
    {
        this.mDatabase = DbHelper.getInstance(this.getContext());
        return false;
    }

    @SuppressWarnings("resource")
    @Override
    public Cursor query(final Uri uri, final String[] projection, final String selection, final String[] selectionArgs,
                    final String sortOrder)
    {
        // Uisng SQLiteQueryBuilder instead of query() method
        final SQLiteQueryBuilder queryBuilder = new SQLiteQueryBuilder();

        // Set the table
        queryBuilder.setTables(this.mTableName);

        final SQLiteDatabase sqlDB = this.mDatabase.getReadableDatabase();

        // build query
        final Cursor cursor = queryBuilder.query(sqlDB, projection, selection, selectionArgs, null, null, sortOrder);

        // Make sure that potential listeners are getting notified
        cursor.setNotificationUri(this.getContext().getContentResolver(), uri);
        return cursor;
    }

    @Override
    public synchronized Uri insert(final Uri uri, final ContentValues values)
    {
        final SQLiteDatabase sqlDB = this.mDatabase.getWritableDatabase();

        try
        {
            // do insert
            final long id = sqlDB.insert(this.mTableName, null, values);

            // notify listeners
            this.getContext().getContentResolver().notifyChange(uri, null);

            // return uri to new record
            return Uri.parse(uri + "/" + id); //$NON-NLS-1$
        }
        finally
        {
            // clean up afterwards
            sqlDB.close();
        }
    }

    @Override
    public synchronized int update(final Uri uri, final ContentValues values, final String selection,
                    final String[] selectionArgs)
    {
        final SQLiteDatabase sqlDB = this.mDatabase.getWritableDatabase();

        try
        {
            // do update
            final int rowsUpdated = sqlDB.update(this.mTableName, values, selection, selectionArgs);

            // notify listeners
            this.getContext().getContentResolver().notifyChange(uri, null);

            // return rows effected
            return rowsUpdated;
        }
        finally
        {
            // clean up afterwards
            sqlDB.close();
        }
    }

    @Override
    public synchronized int delete(final Uri uri, final String selection, final String[] selectionArgs)
    {
        final SQLiteDatabase sqlDB = this.mDatabase.getWritableDatabase();
        try
        {
            // do query
            final int rowsDeleted = sqlDB.delete(this.mTableName, selection, selectionArgs);

            // inform listeners
            this.getContext().getContentResolver().notifyChange(uri, null);

            // return rows effected
            return rowsDeleted;
        }
        finally
        {
            // clean up afterwards
            sqlDB.close();
        }

    }

    @Override
    public String getType(final Uri uri)
    {
        return null;
    }

    public void close()
    {
        if (this.mDatabase != null)
        {
            this.mDatabase.close();
        }
    }
}