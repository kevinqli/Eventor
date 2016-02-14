package com.eventor.eventor;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.MenuItem;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.util.Log;
import android.view.Gravity;
import android.view.SubMenu;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.content.ActivityNotFoundException;
import android.widget.TextView;
import android.widget.Toast;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    MaterialCalendarView myCalendar;

    static final String ACTION_SCAN = "com.google.zxing.client.android.SCA";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.eventor.eventor.R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(com.eventor.eventor.R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle(null);

        Toolbar toolbarTop = (Toolbar) findViewById(R.id.toolbar);
        TextView mTitle = (TextView) toolbarTop.findViewById(R.id.toolbar_title);

        Typeface roboto = Typeface.createFromAsset(getApplication().getAssets(), "fonts/Roboto-Regular.ttf");

        mTitle.setTypeface(roboto);

        FloatingActionButton fab = (FloatingActionButton) findViewById(com.eventor.eventor.R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(), NewEventActivity.class));
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(com.eventor.eventor.R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
            this, drawer, toolbar, com.eventor.eventor.R.string.navigation_drawer_open, com.eventor.eventor.R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(com.eventor.eventor.R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Menu menu = navigationView.getMenu();

        MenuItem item = menu.findItem(R.id.nav_groups);
        SubMenu sub = item.getSubMenu();
        List<Group> groups = Group.groups_data;
        for (Group group : groups) {
            MenuItem subItem= sub.add(Menu.NONE, group.getId(), Menu.NONE, group.getGroupTitle());
            subItem.setIcon(getResources().getIdentifier(group.getIcon(),"drawable",getPackageName()));
        }

        initializeCalendar();
    }

    private void initializeCalendar() {
        myCalendar = (MaterialCalendarView) findViewById(R.id.calendarView);
        Color myColor = new Color();
        myCalendar.setSelectionColor(myColor.rgb(245, 32, 32));
        myCalendar.setOnDateChangedListener(new OnDateSelectedListener() {
            @Override
            public void onDateSelected(MaterialCalendarView widget, CalendarDay date, boolean selected) {
                SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
                Date d = date.getDate();
                String dayOfTheWeek = sdf.format(d);

                Intent intent = new Intent(getApplicationContext(), DayActivity.class);
                Bundle extras = new Bundle();
                extras.putString("YEAR",Integer.toString(date.getYear()));
                extras.putString("MONTH", Integer.toString(date.getMonth() + 1));
                extras.putString("DAY", Integer.toString(date.getDay()));
                extras.putString("DAYOFWEEK", dayOfTheWeek);
                intent.putExtras(extras);
                startActivity(intent);


            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(com.eventor.eventor.R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(com.eventor.eventor.R.menu.main, menu);
        menu.getItem(0).setIcon(getResources().getDrawable((R.drawable.ic_more_vert_black_24dp)));
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == com.eventor.eventor.R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        Log.d("name", item.toString());
        Log.d("id", Integer.toString(id));

        if (id == R.id.nav_qrcode) {
            try {
                Intent intent = new Intent("com.google.zxing.client.android.SCAN");
                intent.putExtra("SCAN_MODE", "QR_CODE_MODE");
                startActivityForResult(intent, 0);
            } catch (ActivityNotFoundException anfe) {
                Log.e("onCreate", "Scanner Not Found", anfe);
            }
        } else if (id == R.id.nav_friends) {
            startActivity(new Intent(this, FriendsPageActivity.class));
        } else if (Group.getGroup(id) != null) {
            Intent intent = new Intent(this, GroupPageActivity.class);
            intent.putExtra("id", id);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(com.eventor.eventor.R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == 0) {
            if (resultCode == RESULT_OK) {
                String contents = intent.getStringExtra("SCAN_RESULT");
                String format = intent.getStringExtra("SCAN_RESULT_FORMAT");
                // Handle successful scan
                Toast toast = Toast.makeText(this, "Content:" + contents + " Format:" + format , Toast.LENGTH_LONG);
                toast.setGravity(Gravity.TOP, 25, 400);
                toast.show();
            } else if (resultCode == RESULT_CANCELED) {
                // Handle cancel
                Toast toast = Toast.makeText(this, "Scan was Cancelled!", Toast.LENGTH_LONG);
                toast.setGravity(Gravity.TOP, 25, 400);
                toast.show();

            }
        }
    }
}
