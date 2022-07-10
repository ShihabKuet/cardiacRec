package com.example.cardiacrecorder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class addRecord extends AppCompatActivity {

    TextView time_text,date_text;

    Spinner ex_spin, pos_spin;
    String[] extrimity ={"Right Arm","Left Arm","Right Calf","Left Calf","Right Thigh","Left Thigh"};
    String[] position ={"Seated","Lying","Standing"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_record);

        time_text=findViewById(R.id.timetxt);
        date_text=findViewById(R.id.datetxt);

        //Current Time and Date add
        Calendar calendar=Calendar.getInstance();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("hh:mm a");
        String time = simpleDateFormat.format(calendar.getTime());
        time_text.setText(time);
        SimpleDateFormat simpleDateFormat2=new SimpleDateFormat("dd-MMM-yy");
        String date = simpleDateFormat2.format(calendar.getTime());
        date_text.setText(date);

    /*
    ex_spin variable
    extrimity value showing dropdown list
     */
        ex_spin = findViewById(R.id.extrimity_spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(addRecord.this,R.layout.selected_dropdown_item,extrimity);
        adapter.setDropDownViewResource(R.layout.dropped_item);
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

    /*
    pos_spin variable
    position value showing dropdown list
     */

        pos_spin = findViewById(R.id.position_spinner);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(addRecord.this,R.layout.selected_dropdown_item,position);
        adapter1.setDropDownViewResource(R.layout.dropped_item);
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