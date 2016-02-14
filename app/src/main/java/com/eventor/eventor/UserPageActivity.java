package com.eventor.eventor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;
import android.widget.AdapterView.OnItemSelectedListener;
import android.view.*;

import java.util.List;

public class UserPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.eventor.eventor.R.layout.activity_user_page);

        Intent intent = getIntent();
        User user = User.getUser(intent.getIntExtra("id", -1));

        Spinner following = (Spinner) findViewById(com.eventor.eventor.R.id.following);
        List<Integer> groups = user.getGroupList();
        List<String> followingItems = new List<String>;
        for (Integer group : groups) {
            followingItems.add(Group.getGroup(group).getGroupTitle());
        }
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
                Intent intent = new Intent(UserPageActivity.this, FriendsPageActivity.class);
                startActivity(intent);
            }
        });
    }
}