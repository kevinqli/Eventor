package com.eventor.eventor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
        TableLayout table = (TableLayout) findViewById(R.id.groupTable);
        Intent intent = getIntent();
        Group group = Group.getGroup(intent.getIntExtra("id", -1));
        List<Integer> events = group.getEventList();
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
            txt.setTextSize(30);
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
}
