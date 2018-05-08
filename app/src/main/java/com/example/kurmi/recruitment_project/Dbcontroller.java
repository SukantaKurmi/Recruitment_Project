package com.example.kurmi.recruitment_project;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.TextView;

public class Dbcontroller extends SQLiteOpenHelper {

    public Dbcontroller(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, "Test.db", factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE CANDIDATES(ID INTEGER PRIMARY KEY AUTOINCREMENT,COMPANYID TEXT UNIQUE,COMPANYNAME TEXT,PASSWORD TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS CANDIDATES");
        onCreate(db);
    }

    public void insert_candidates(String userid, String cmpname, String pwd) {
        ContentValues cv = new ContentValues();
        cv.put("COMPANYID", userid);
        cv.put("COMPANYNAME", cmpname);
        cv.put("PASSWORD", pwd);
        this.getWritableDatabase().insertOrThrow("CANDIDATES", "", cv);
    }

    public int search(String userid, String cmpname, String pwd) {
        int b = 0;
        Cursor c = this.getReadableDatabase().rawQuery("SELECT * FROM CANDIDATES", null);
        while (c.moveToNext()) {
            if (userid.equals(c.getString(1)) && cmpname.equals(c.getString(2)) && pwd.equals(c.getString(3))) {
                b = 1;
            }
        }
        return b;
    }

    public void delete_candidates(String userid) {
        this.getWritableDatabase().delete("CANDIDATES", "COMPANYID='" + userid + "'", null);
    }

    public void list_candidates(TextView tv) {
        Cursor c = this.getReadableDatabase().rawQuery("SELECT * FROM CANDIDATES", null);
        tv.setText(" ");
        while (c.moveToNext()) {
            tv.append("\n" + c.getString(1) + " " + c.getString(2) + " " + c.getString(3));
        }
    }


}
