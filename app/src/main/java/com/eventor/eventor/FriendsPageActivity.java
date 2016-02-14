package com.eventor.eventor;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
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

        TableLayout table = (TableLayout) findViewById(R.id.friendsTable);
        List<User> users = User.users_data;
        for (User user : users) {
            TableRow tr = new TableRow(this);

            tr.setBackgroundResource(R.drawable.customfriendbackground);
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
            txt.setTextColor(Color.parseColor("#FFFFFF"));
            txt.setTextSize(20);
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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        if(itemId == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
