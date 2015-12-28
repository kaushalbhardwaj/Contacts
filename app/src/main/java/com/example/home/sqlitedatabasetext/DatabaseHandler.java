package com.example.home.sqlitedatabasetext;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.home.sqlitedatabasetext.Database.Contact;
import com.example.home.sqlitedatabasetext.Database.MySqliteHelper;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by home on 10/8/2015.
 */
public class DatabaseHandler {

    MySqliteHelper sh;
    SQLiteDatabase db;
    public DatabaseHandler(Context context)
    {
        sh=new MySqliteHelper(context);

    }
    public void open() throws SQLException
    {
        db=sh.getWritableDatabase();
    }
    public void close()
    {
        sh.close();
    }
    public long insert(Contact con)
    {
        ContentValues cv=new ContentValues();
        cv.put(MySqliteHelper.ColName,con.getName());
        cv.put(MySqliteHelper.ColPhone,con.getPhone());
        cv.put(MySqliteHelper.ColCity,con.getCity());
        
        long i=db.insert(MySqliteHelper.TBName, null, cv);
        return i;
    }
    public void update(Contact con)
    {
        ContentValues cv=new ContentValues();
        cv.put(MySqliteHelper.ColName, con.getName());
        cv.put(MySqliteHelper.ColPhone,con.getPhone());
        cv.put(MySqliteHelper.ColCity,con.getCity());
        db.update(MySqliteHelper.TBName, cv, MySqliteHelper.ColId + "=" + con.getId(), null);
    }
    public void delete(long i)
    {
        db.delete(MySqliteHelper.TBName, MySqliteHelper.ColId + "=" + i, null);

    }
    public List<Contact> getData()
    {
        Contact c;
        List<Contact> con=new ArrayList<Contact>();
        Cursor curs=db.query(MySqliteHelper.TBName,new String[] {MySqliteHelper.ColId,MySqliteHelper.ColName,MySqliteHelper.ColPhone,MySqliteHelper.ColCity}
                ,null,null,null,null,null,null);
        curs.moveToFirst();
        while(!curs.isAfterLast())
        {
            c=cursorToContact(curs);
            con.add(c);
            curs.moveToNext();
        }

        curs.close();
        return con;

    }

    public Contact cursorToContact(Cursor curs)
    {
        Contact c=new Contact();
        c.setId(curs.getLong(0));
        c.setName(curs.getString(1));
        c.setPhone(curs.getString(2));
        c.setCity(curs.getString(3));
        return c;

    }
}
