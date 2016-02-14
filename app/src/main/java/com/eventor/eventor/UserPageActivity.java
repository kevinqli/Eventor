package com.eventor.eventor;

import android.content.Intent;
import android.graphics.Typeface;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.*;
import android.widget.*;
import android.widget.AdapterView.OnItemSelectedListener;
import android.view.*;
import android.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class UserPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.eventor.eventor.R.layout.activity_user_page);

        Intent intent = getIntent();
        User user = User.getUser(intent.getIntExtra("id", -1));

        ImageView pic = (ImageView) findViewById(R.id.profilePicture);
        int id = getResources().getIdentifier(user.getImage(), "drawable", getPackageName());
        pic.setImageResource(id);

        TextView name = (TextView) findViewById(R.id.userLabel);
        name.setText(user.getUserName());

        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        if(toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle(null);
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            TextView toolbarTitle = (TextView) findViewById(R.id.toolbar_title);
            toolbarTitle.setText(user.getUserName());
        }

        android.support.v7.widget.Toolbar toolbarTop = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        TextView mTitle = (TextView) toolbarTop.findViewById(R.id.toolbar_title);

        Typeface roboto = Typeface.createFromAsset(getApplication().getAssets(), "fonts/Roboto-Regular.ttf");

        mTitle.setTypeface(roboto);

        Spinner groupsSpinner = (Spinner) findViewById(com.eventor.eventor.R.id.groups);
        List<Integer> groups = user.getGroupList();
        List<String> followingItems = new ArrayList<String>();
        for (Integer group : groups) {
            followingItems.add(Group.getGroup(group).getGroupTitle());
        }
        ArrayAdapter<String> followingAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, followingItems);
        groupsSpinner.setAdapter(followingAdapter);
        groupsSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Spinner eventSpinner = (Spinner) findViewById(com.eventor.eventor.R.id.events);
        List<Integer> events = user.getEventList();
        List<String> eventsItems = new ArrayList<String>();
        for (Integer event : events) {
            eventsItems.add(Event.getEvent(event).getEventName());
        }
        ArrayAdapter<String> eventsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, eventsItems);
        eventSpinner.setAdapter(eventsAdapter);
        eventSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {
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
                Intent intent = new Intent(UserPageActivity.this, FriendsPageActivity.class);
                startActivity(intent);
            }
        });
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