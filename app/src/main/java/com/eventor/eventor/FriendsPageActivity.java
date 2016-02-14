package com.eventor.eventor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.content.*;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class FriendsPageActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.eventor.eventor.
                R.layout.activity_friends_page);
        TableLayout table = (TableLayout) findViewById(R.id.friendsTable);
        for (User user : User.users_data) {
            TableRow tr = new TableRow(this);
            tr.setOnClickListener(this);
            tr.setId(user.getId());
            TextView txt = new TextView(this);
            txt.setText(user.getUserName());
            txt.setTextSize(30);
            txt.setPadding(3, 3, 3, 3);
            tr.addView(txt);
            table.addView(tr);
        }

    }

    public void onClick(View view) {
        Intent intent = new Intent(FriendsPageActivity.this, UserPageActivity.class);
        intent.putExtra("id", view.getId());
        startActivity(intent);
    }
}
