package com.example.cardiacrecorder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class addRecord extends AppCompatActivity {

    Spinner ex_spin, pos_spin;
    String[] extrimity ={"Right Arm","Left Arm","Right Calf","Left Calf","Right Thigh","Left Thigh"};
    String[] position ={"Seated","Lying","Standing"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_record);
        ex_spin=findViewById(R.id.extrimity_spinner);
        ArrayAdapter<String> adapter= new ArrayAdapter<String>(addRecord.this,android.R.layout.simple_spinner_item,extrimity);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ex_spin.setAdapter(adapter);

        ex_spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String value=adapterView.getItemAtPosition(i).toString();
                //Toast.makeText(addRecord.this,value, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        pos_spin=findViewById(R.id.position_spinner);
        ArrayAdapter<String> adapter1= new ArrayAdapter<String>(addRecord.this,android.R.layout.simple_spinner_item,position);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        pos_spin.setAdapter(adapter1);



        pos_spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String value=adapterView.getItemAtPosition(i).toString();
                //Toast.makeText(addRecord.this,value, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }
}