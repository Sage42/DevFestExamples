package org.sage42.devfest.d.test;

import org.robolectric.annotation.Implementation;
import org.robolectric.annotation.Implements;
import org.robolectric.shadows.ShadowSQLiteDatabase;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.CancellationSignal;

@Implements(value = SQLiteDatabase.class, inheritImplementationMethods = true)
public class CustomSQLiteShadow extends ShadowSQLiteDatabase
{

    /**
     * @param cursorFactory
     * @param sql
     * @param selectionArgs
     * @param editTable
     * @param cancellationSignal
     * @return
     */
    @Implementation
    public Cursor rawQueryWithFactory(final SQLiteDatabase.CursorFactory cursorFactory, final String sql,
                    final String[] selectionArgs, final String editTable, final CancellationSignal cancellationSignal)
    {
        return this.rawQueryWithFactory(cursorFactory, sql, selectionArgs, editTable);
    }
}
