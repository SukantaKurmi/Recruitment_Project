package com.example.kurmi.recruitment_project;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.TextView;

public class Dbcontroller1 extends SQLiteOpenHelper {
    public Dbcontroller1(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context,"Test.db1", factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db1) {
        db1.execSQL("CREATE TABLE STU(ID INTEGER PRIMARY KEY AUTOINCREMENT,F1 TEXT,F2 TEXT,F3 TEXT,F4 TEXT,F5 TEXT,F6 TEXT,F7 TEXT,F8 TEXT,F9 TEXT,F10 TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db1, int oldVersion, int newVersion) {
        db1.execSQL("DROP TABLE IF EXISTS STU");
        onCreate(db1);

    }
    public void insert_field(String roll, String name,String gender,String mail,String con,String age,String add,String cgpa,String hsc,String ssc) {
        ContentValues cv = new ContentValues();
        cv.put("F1", roll);
        cv.put("F2", name);
        cv.put("F3",gender);
        cv.put("F4",mail);
        cv.put("F5",con);
        cv.put("F6",age);
        cv.put("F7",add);
        cv.put("F8",cgpa);
        cv.put("F9",hsc);
        cv.put("F10",ssc);

        this.getWritableDatabase().insertOrThrow("Stu", "", cv);
    }

    public void delete_stu(String roll) {
        this.getWritableDatabase().delete("STU", "F1='" + roll + "'", null);
    }
    public void list_allstu(TextView tv){
        Cursor c=this.getReadableDatabase().rawQuery("SELECT * FROM STU",null);
        tv.setText("");
        while(c.moveToNext())
        {
            tv.append("\n"+c.getString(1)+"  "+c.getString(2)+"  "+c.getString(3)+"  "+c.getString(4)+"  "+c.getString(5)+"  "+c.getString(6)+"  "+c.getString(7)+"  "+c.getString(8)+"   "+c.getString(9)+"  "+c.getString(10));
        }
    }
    public int search_stu(String roll, String name) {
        int b = 0;
        Cursor c = this.getReadableDatabase().rawQuery("SELECT * FROM STU", null);
        while (c.moveToNext()) {
            if (roll.equals(c.getString(1)) && name.equals(c.getString(2))) {
                b = 1;
            }
        }
        return b;
    }

    public String search_cgpa(String roll) {
          String cgpa="not found";
        Cursor c = this.getReadableDatabase().rawQuery("SELECT * FROM STU", null);
        while (c.moveToNext()) {
            if (roll.equals(c.getString(1)) ) {
                cgpa=c.getString(8);
            }
        }
        return cgpa;

    }

    public String search_hsc(String roll) {
        String hsc="not found";
        Cursor c = this.getReadableDatabase().rawQuery("SELECT * FROM STU", null);
        while (c.moveToNext()) {
            if (roll.equals(c.getString(1)) ) {
                hsc=c.getString(9);
            }
        }
        return hsc;

    }

    public String search_ssc(String roll) {
        String ssc="not found";
        Cursor c = this.getReadableDatabase().rawQuery("SELECT * FROM STU", null);
        while (c.moveToNext()) {
            if (roll.equals(c.getString(1)) ) {
                ssc=c.getString(10);
            }
        }
        return ssc;

    }



}
