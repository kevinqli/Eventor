package com.eventor.eventor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


public class EventsPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events_page);

        final TextView eventTitle = (TextView) findViewById(R.id.eventTitle);
        final TextView eventDate = (TextView) findViewById(R.id.date);
        final TextView eventLocation = (TextView) findViewById(R.id.location);
        final TextView eventDescription = (TextView) findViewById(R.id.description);

        Intent intent = getIntent();
        Event event = Event.getEvent(intent.getIntExtra("id", -1));


    }
}
