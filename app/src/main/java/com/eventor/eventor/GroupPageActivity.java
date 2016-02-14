package com.eventor.eventor;

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

        ImageView image = (ImageView) findViewById(R.id.groupPicture);
        image.setImageResource(getResources().getIdentifier(group.getIcon(), "drawable", getPackageName()));

        Button button = (Button) findViewById(R.id.statsButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), GroupStatsActivity.class));
            }
        });
        TextView description = (TextView) findViewById(R.id.groupDesc);
        description.setText(group.getGroupDesc());

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
}
