package com.android.babyscare;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;

import java.util.Calendar;

public class DetailsActivity extends AppCompatActivity {

    DatePickerDialog picker;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);


        editText = findViewById(R.id.editText_birth_date);
        editText.setInputType(InputType.TYPE_NULL);
        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar calendar = Calendar.getInstance();
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                int month = calendar.get(Calendar.MONTH);
                int year = calendar.get(Calendar.YEAR);
                // date picker dialog
                //******************************************WANNA Change the theme of date picker*************************
                picker = new DatePickerDialog(DetailsActivity.this, R.style.DatePickerTheme,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                editText.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                            }
                        }, year, month, day);
                picker.show();
            }
        });

        final TextView weightTextView = findViewById(R.id.weightTextView);
        NumberPicker numberPicker = findViewById(R.id.numberPicker);


        //Populate NumberPicker values from minimum and maximum value range
        //Set the minimum value of NumberPicker
        numberPicker.setMinValue(0);
        //Specify the maximum value/number of NumberPicker
        numberPicker.setMaxValue(5);

        //Gets whether the selector wheel wraps when reaching the min/max value.
        numberPicker.setWrapSelectorWheel(true);

        //Set a value change listener for NumberPicker
        numberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                //Display the newly selected number from picker
                weightTextView.setText("Selected Weight : " + newVal);
                weightTextView.setTextColor(Color.parseColor("#EF5350"));
            }
        });


    }


    /**
     * OK Button to move/intent to Main Category Activity screen
     */
    public void okButtonClick(View v) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}
