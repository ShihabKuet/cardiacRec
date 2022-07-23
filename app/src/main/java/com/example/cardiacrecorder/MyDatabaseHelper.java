package com.example.cardiacrecorder;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "CardiacRecord.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "record_table";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_DATE = "date";
    private static final String COLUMN_TIME = "time";
    private static final String COLUMN_SYSTOLIC = "systolic";
    private static final String COLUMN_DIASTOLIC = "diastolic";
    private static final String COLUMN_PULSE = "pulse";
    private static final String COLUMN_EXT = "extrimity";
    private static final String COLUMN_POSITION = "position";
    private static final String COLUMN_COMMENT = "comment";
    private static final String COLUMN_VERDICT = "verdict";


    public MyDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE "+TABLE_NAME+" ( "+COLUMN_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+COLUMN_DATE+" VARCHAR(200), "+COLUMN_TIME+" VARCHAR(200), "+COLUMN_SYSTOLIC+" INTEGER, "+COLUMN_DIASTOLIC+" INTEGER, "+COLUMN_PULSE+" INTEGER, "+COLUMN_EXT+" VARCHAR(200), "+COLUMN_POSITION+" VARCHAR(200), "+COLUMN_COMMENT+" VARCHAR(200), "+COLUMN_VERDICT+" VARCHAR(200));";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public void addData(String date, String time, int systolic, int diastolic, int pulse, String ext, String position, String comment, String verdict){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_DATE, date);
        cv.put(COLUMN_TIME, time);
        cv.put(COLUMN_SYSTOLIC, systolic);
        cv.put(COLUMN_DIASTOLIC, diastolic);
        cv.put(COLUMN_PULSE, pulse);
        cv.put(COLUMN_EXT, ext);
        cv.put(COLUMN_POSITION, position);
        cv.put(COLUMN_COMMENT, comment);
        cv.put(COLUMN_VERDICT, verdict);
        long result = db.insert(TABLE_NAME,null,cv);
        db.close();
        if(result==-1){
            Toast.makeText(context, "Failed To Insert Data", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(context, "Successfully Recorded", Toast.LENGTH_SHORT).show();
        }
    }
}
