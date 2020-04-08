package com.example.secondexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    // If a new view is added first you have to declare it globally
    TextView date,time;
    int year,month,day,mints,hours;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //you to instantiate the views
        date = findViewById(R.id.date);
        time = findViewById(R.id.time);
    }

  

    public void datePicker(View view) {
        Calendar c=Calendar.getInstance();
        year=c.get(Calendar.YEAR);
        month=c.get(Calendar.MONTH);
        day = c.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog dpd = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                date.setText(""+dayOfMonth+"/"+(month+1)+"/"+year);
            }
        },year,month,day);
        dpd.show();
    }
    public void timePicker(View view){
        Calendar c= Calendar.getInstance();
        hours= c.get(Calendar.HOUR_OF_DAY);
        mints=c.get(Calendar.MINUTE);
        TimePickerDialog tpd= new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                time.setText(""+hourOfDay+":"+minute);
            }
        },hours,mints,true);
        tpd.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.exit:
                AlertDialog.Builder builder=new AlertDialog.Builder(this);
                builder.setTitle("Alert");
                builder.setMessage("Are you wanna exit ?");
                builder.setIcon(R.drawable.ic_launcher_foreground);
                builder.setCancelable(false);
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.show();

        }
        return super.onOptionsItemSelected(item);
    }
}
