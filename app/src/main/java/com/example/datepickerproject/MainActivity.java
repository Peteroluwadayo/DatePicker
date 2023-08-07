package com.example.datepickerproject;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText dateEditText;

    DatePickerDialog myDatePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initListeners();

    }
    public void initView() {
        dateEditText = findViewById(R.id.et_date_of_birth);

    }
    public void initListeners() {
        dateEditText.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                final Calendar myCalendar = Calendar.getInstance();
                int myDay = myCalendar.get(Calendar.DAY_OF_MONTH);
                int myMonth = myCalendar.get(Calendar.MONTH);
                int myYear = myCalendar.get(Calendar.YEAR);

                //create a day picker Dialog
                myDatePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        // Set your date in the EditText
                        dateEditText.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
                    }
                },myDay,myMonth,myYear);
                myDatePickerDialog.show();
            }
        });

    }
}