package com.eventor.eventor;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class NewEventActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView fromDateEtxt;
    private TextView toDateEtxt;
    private TextView fromTimeEtxt;
    private TextView toTimeEtxt;


    private DatePickerDialog fromDatePickerDialog;
    private DatePickerDialog toDatePickerDialog;
    private TimePickerDialog fromTimePickerDialog;
    private TimePickerDialog toTimePickerDialog;

    private SimpleDateFormat dateFormatter;
    private SimpleDateFormat timeFormatter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.eventor.eventor.R.layout.activity_new_event);
        setTitle("New Event");

        dateFormatter = new SimpleDateFormat("EEE, MMM dd, yyyy", Locale.US);
        timeFormatter = new SimpleDateFormat("h:mm aa", Locale.US);

        findViewsById();

        setDateTimeField();
    }

    private void findViewsById() {
        fromDateEtxt = (EditText) findViewById(com.eventor.eventor.R.id.etxt_fromdate);
        fromDateEtxt.setInputType(InputType.TYPE_NULL);

        toDateEtxt = (EditText) findViewById(com.eventor.eventor.R.id.etxt_todate);
        toDateEtxt.setInputType(InputType.TYPE_NULL);

        fromTimeEtxt = (EditText) findViewById(com.eventor.eventor.R.id.etxt_fromtime);
        fromTimeEtxt.setInputType(InputType.TYPE_NULL);

        toTimeEtxt = (EditText) findViewById(com.eventor.eventor.R.id.etxt_totime);
        toTimeEtxt.setInputType(InputType.TYPE_NULL);
    }

    private void setDateTimeField() {
        fromDateEtxt.setOnClickListener(this);
        toDateEtxt.setOnClickListener(this);
        fromTimeEtxt.setOnClickListener(this);
        toTimeEtxt.setOnClickListener(this);

        Calendar newCalendar = Calendar.getInstance();

        fromDatePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                fromDateEtxt.setText(dateFormatter.format(newDate.getTime()));
            }

        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        toDatePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                toDateEtxt.setText(dateFormatter.format(newDate.getTime()));
            }

        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        fromTimePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {

            public void onTimeSet(TimePicker view, int hour, int minute) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(0, 0, 0, hour, minute, 0);
                fromTimeEtxt.setText(timeFormatter.format(newDate.getTime()));
            }

        },newCalendar.get(Calendar.HOUR_OF_DAY), newCalendar.get(Calendar.MINUTE), true);

        toTimePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {

            public void onTimeSet(TimePicker view, int hour, int minute) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(0, 0, 0, hour, minute, 0);
                toTimeEtxt.setText(timeFormatter.format(newDate.getTime()));
            }

        },newCalendar.get(Calendar.HOUR_OF_DAY), newCalendar.get(Calendar.MINUTE), true);
    }

    public void onClick(View view) {
        if (view == fromDateEtxt) {
            fromDatePickerDialog.show();
        } else if (view == toDateEtxt) {
            toDatePickerDialog.show();
        } else if (view == fromTimeEtxt) {
            fromTimePickerDialog.show();
        } else if (view == toTimeEtxt) {
            toTimePickerDialog.show();
        }
    }
}
