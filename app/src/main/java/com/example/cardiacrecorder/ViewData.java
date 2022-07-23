package com.example.cardiacrecorder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ViewData extends AppCompatActivity {

    ListView lst;
    //ArrayList<String> datas = new ArrayList<>(String);
    ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_data);

        SQLiteDatabase sqLiteDatabase = openOrCreateDatabase("SLiteDb", Context.MODE_PRIVATE,null);
    }
}