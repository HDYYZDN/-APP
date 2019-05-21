package com.example.mylogin.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class DataBaseHelper extends SQLiteOpenHelper {
    public static final String CREATE_USERDATA="create table userData(" +
            "id integer primary key autoincrement,"
            +"email text,"
            +"password text)";

    private Context mContext;
    public DataBaseHelper(Context context,String name,SQLiteDatabase.CursorFactory cursorFactory,int version) {
        super(context, name, cursorFactory, version);
        context = mContext;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_USERDATA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
