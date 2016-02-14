package com.eventor.eventor;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;


public class EventsPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events_page);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if(toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle(null);
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        Toolbar toolbarTop = (Toolbar) findViewById(R.id.toolbar);
        TextView mTitle = (TextView) toolbarTop.findViewById(R.id.toolbar_title);

        Typeface roboto = Typeface.createFromAsset(getApplication().getAssets(), "fonts/Roboto-Regular.ttf");

        mTitle.setTypeface(roboto);

        final TextView eventTitle = (TextView) findViewById(R.id.eventTitle);
        final TextView eventDate = (TextView) findViewById(R.id.date);
        final TextView eventTime = (TextView) findViewById(R.id.time);
        final TextView eventLocation = (TextView) findViewById(R.id.location);
        final TextView eventDescription = (TextView) findViewById(R.id.description);

        Intent intent = getIntent();
        Event event = Event.getEvent(intent.getIntExtra("id", -1));

        SimpleDateFormat sdf = new SimpleDateFormat("h:mm a");
        SimpleDateFormat sdf2 = new SimpleDateFormat("MM/dd");

        Date d = event.getEventStart();
        String startTimeText = sdf.format(d);
        String startDateText = sdf2.format(d);

        Date d2 = event.getEventEnd();
        String endTimeText = sdf.format(d2);
        String endDateText = sdf2.format(d2);


        eventTitle.setText(event.getEventName());
        eventDate.setText(startDateText + " to " + endDateText);
        eventTime.setText(startTimeText + " to " + endTimeText);
        eventLocation.setText("Location: Stanford");
        eventDescription.setText(event.getEventDesc());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        if(itemId == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
