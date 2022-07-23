package com.example.cardiacrecorder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;

public class showHistory extends AppCompatActivity {
    Button b;
    FirebaseAuth mAuth;
    FirebaseUser mUser;

    MyDatabaseHelper myDatabaseHelper;
    SQLiteDatabase sqLiteDatabase;
    RecyclerView recyclerView;
    MyAdapter myAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_history);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();
        b=findViewById(R.id.signoutbtn);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth.signOut();
                signOutUser();
            }
        });

        myDatabaseHelper = new MyDatabaseHelper(this);
        findid();
        DisplayData();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void DisplayData() {
        sqLiteDatabase = myDatabaseHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from record_table",null);
        ArrayList<Model>modelArrayList=new ArrayList<>();
        while (cursor.moveToNext()){
            int id = cursor.getInt(0);
            String date = cursor.getString(1);
            String time = cursor.getString(2);
            int systolic = cursor.getInt(3);
            int diastolic = cursor.getInt(4);
            int pulse = cursor.getInt(5);
            String extrimity = cursor.getString(6);
            String position= cursor.getString(7);
            String comment = cursor.getString(8);
            String verdict = cursor.getString(9);
            modelArrayList.add(new Model(id, date, time, systolic, diastolic, pulse, extrimity, position, comment, verdict));
        }
        cursor.close();
        myAdapter = new MyAdapter(this, R.layout.singledata,modelArrayList,sqLiteDatabase);
        recyclerView.setAdapter(myAdapter);
    }


    private void findid() {
        recyclerView=findViewById(R.id.rv);
    }



    private void signOutUser() {
        Intent intent = new Intent(showHistory.this, Login.class);
        startActivity(intent);
        finish();
    }

}