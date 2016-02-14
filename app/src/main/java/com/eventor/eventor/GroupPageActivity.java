package com.eventor.eventor;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.*;
import java.util.*;
import android.content.Intent;
public class GroupPageActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_page);
        TableLayout table = (TableLayout) findViewById(R.id.eventTable);
        Intent intent = getIntent();
        Group group = Group.getGroup(intent.getIntExtra("id", -1));
        List<Integer> events = group.getEventList();

        TextView title = (TextView) findViewById(R.id.groupLabel);
        title.setText(group.getGroupTitle());

        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        if(toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle(null);
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            TextView toolbarTitle = (TextView) findViewById(R.id.toolbar_title);
            toolbarTitle.setText(group.getGroupTitle());
        }

        android.support.v7.widget.Toolbar toolbarTop = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        TextView mTitle = (TextView) toolbarTop.findViewById(R.id.toolbar_title);

        Typeface roboto = Typeface.createFromAsset(getApplication().getAssets(), "fonts/Roboto-Regular.ttf");

        mTitle.setTypeface(roboto);

        ImageView image = (ImageView) findViewById(R.id.groupPicture);
        image.setImageResource(getResources().getIdentifier(group.getIcon(), "drawable", getPackageName()));

        Button button = (Button) findViewById(R.id.statsButton);
        button.setTypeface(roboto);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), GroupStatsActivity.class));
            }
        });


        TextView description = (TextView) findViewById(R.id.groupDesc);
        description.setTypeface(roboto);
        description.setText("Events: " + group.getGroupDesc());

        for (Integer event : events) {
            TableRow tr = new TableRow(this);
            tr.setOnClickListener(this);
            tr.setId(event);
            /*
            ImageView img = new ImageView(this);
            img.setMaxWidth(150);
            img.setMaxHeight(150);
            img.setPadding(20, 20, 20, 20);
            img.setAdjustViewBounds(true);
            int id = getResources().getIdentifier(event.getIcon(), "drawable", getPackageName());
            img.setImageResource(id);
            tr.addView(img);
            */
            TextView txt = new TextView(this);
            txt.setText(Event.getEvent(event).getEventName());
            txt.setTextSize(20);
            txt.setPadding(20, 20, 20, 20);
            tr.addView(txt);
            table.addView(tr);
        }
    }
    public void onClick(View view) {
        Intent intent = new Intent(GroupPageActivity.this, EventsPageActivity.class);
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
