package com.eventor.eventor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;
import android.widget.AdapterView.OnItemSelectedListener;
import android.view.*;

public class userPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.eventor.eventor.R.layout.activity_user_page);

        Spinner following = (Spinner) findViewById(com.eventor.eventor.R.id.following);
        String[] followingItems = new String[] { "Following", "Stanford TreeHacks", "Stanford CS", "Stanford Football" };
        ArrayAdapter<String> followingAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, followingItems);
        following.setAdapter(followingAdapter);
        following.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Spinner events = (Spinner) findViewById(com.eventor.eventor.R.id.events);
        String[] eventsItems = new String[] { "Upcoming Events", "Stanford TreeHacks", "CS Career Fair", "Stanford vs. Cal" };
        ArrayAdapter<String> eventsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, eventsItems);
        following.setAdapter(eventsAdapter);
        following.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Button firstButton = (Button) findViewById(com.eventor.eventor.R.id.friendsButton);
        firstButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(userPage.this, friends_page.class);
                startActivity(intent);
            }
        });
    }
}