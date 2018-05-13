package com.example.android.amas;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;

public class AttendanceActivity extends AppCompatActivity {
    Button btnDatepicker;
    Dialog myDialog;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance);

        btnDatepicker=(Button)findViewById(R.id.datepickerbutton);
        //myDialog=new Dialog(getApplicationContext());
        //myDialog.setContentView(R.layout.time_picker);
        //myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        btnDatepicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // myDialog.show();
            }
        });

        /*DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                int yearSelected  = year;
                //int monthSele
            }
        };

        TimePickerDialog.OnTimeSetListener myTimeListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int hours, int minutes) {

            }
        };*/
    }

}
