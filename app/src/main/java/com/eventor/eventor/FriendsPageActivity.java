package com.eventor.eventor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.content.*;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class FriendsPageActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.eventor.eventor.
                R.layout.activity_friends_page);
        TableLayout table = (TableLayout) findViewById(R.id.friendsTable);
        List<User> users = User.users_data;
        for (User user : users) {
            TableRow tr = new TableRow(this);
            tr.setOnClickListener(this);
            tr.setId(user.getId());
            ImageView img = new ImageView(this);
            img.setMaxWidth(150);
            img.setMaxHeight(150);
            img.setPadding(20, 20, 20, 20);
            img.setAdjustViewBounds(true);
            int id = getResources().getIdentifier(user.getImage(), "drawable", getPackageName());
            img.setImageResource(id);
            tr.addView(img);
            TextView txt = new TextView(this);
            txt.setText(user.getUserName());
            txt.setTextSize(30);
            txt.setPadding(20, 20, 20, 20);
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
