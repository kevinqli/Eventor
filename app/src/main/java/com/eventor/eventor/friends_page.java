package com.eventor.eventor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.content.*;

public class friends_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.eventor.eventor.R.layout.activity_friends_page);
    }

    public void nextScreen(View view) {
        Intent intent = new Intent(friends_page.this, userPage.class);
        startActivity(intent);
    }
}
