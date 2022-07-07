package com.example.cardiacrecorder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class home_2 extends AppCompatActivity {
    ImageView addRecord,showHistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home2);

        addRecord=findViewById(R.id.addRecord);
        showHistory=findViewById(R.id.showHistory);


        /* making image clickable to jump to record adding */
        addRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(home_2.this, addRecord.class);
                startActivity(intent);
            }
        });

        /* making image clickable to jump to show bp recorded */
        showHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(home_2.this, showHistory.class);
                startActivity(intent);

            }
        });


    }

}