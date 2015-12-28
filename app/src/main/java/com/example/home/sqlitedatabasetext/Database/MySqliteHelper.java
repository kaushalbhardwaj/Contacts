package com.example.home.sqlitedatabasetext.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by home on 10/8/2015.
 */
public class MySqliteHelper extends SQLiteOpenHelper {

    public static String DBName="Contacts";
    public static int DBVersion=1;
    public static String TBName="Contact";
    public static String ColId="_id";
    public static String ColName="name";
    public static String ColPhone="phone";
    public static String ColCity="city";
    public static String create=
            "CREATE TABLE "+ TBName
                    +"("+ColId+" integer primary key autoincrement, "
                    +ColName+" text not null, "
                    +ColPhone+" text not null, "
                    + ColCity+" text not null);";;

    public MySqliteHelper(Context context) {
        super(context, DBName, null, DBVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(create);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS "+TBName);
        onCreate(db);
    }
}
