package com.eventor.eventor;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class DayActivity extends AppCompatActivity {

    private final int[] myDays = {R.id.sunday, R.id.monday, R.id.tuesday, R.id.wednesday, R.id.thursday, R.id.friday, R.id.saturday};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day);

        Bundle extras = getIntent().getExtras();
        String day = "";
        String month = "";
        String year = "";
        String startingDay = "";

        if (extras != null) {
            day = extras.getString("DAY");
            month = extras.getString("MONTH");
            year = extras.getString("YEAR");
            startingDay = extras.getString("DAYOFWEEK");
        }

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

        fillGridNumbers(day, month, year, startingDay);

        fillEventDayOne();

    }

    public void toFirstEvent(View v){
        Log.v("test", "this executes here");
        Intent intent = new Intent(this, EventsPageActivity.class);
        intent.putExtra("ITEMINDEX", 0);
        Log.v("test", "processed correctly");
        startActivity(intent);
    }

    private void fillEventDayOne(){
        Event firstEvent = Event.events_data.get(0);

        TextView title = (TextView) findViewById(R.id.title);
        TextView description = (TextView) findViewById(R.id.description);
        TextView startTime = (TextView) findViewById(R.id.startTime);
        TextView endTime = (TextView) findViewById(R.id.endTime);

        title.setText(firstEvent.getEventName());
        description.setText(firstEvent.getEventDesc());

        SimpleDateFormat sdf = new SimpleDateFormat("h:mm a");
        Date d = firstEvent.getEventStart();
        String startTimeText = sdf.format(d);

        Date d2 = firstEvent.getEventEnd();
        String endTimeText = sdf.format(d2);


        startTime.setText(startTimeText);
        endTime.setText(endTimeText);


    }

    private void fillGridNumbers(String day, String month, String year, String startingDay){
        int iYear = Integer.parseInt(year);
        int iMonth = Integer.parseInt(month);
        int iDay = Integer.parseInt(day);


        Calendar mycal = new GregorianCalendar(iYear, iMonth, iDay);
        int daysInMonth = mycal.getActualMaximum(Calendar.DAY_OF_MONTH);

        int beforeIndex = iMonth - 1;
        if(iMonth == 0){
            beforeIndex = 12;
        }
        mycal = new GregorianCalendar(iYear, beforeIndex, iDay);
        int daysInMonthBefore = mycal.getActualMaximum(Calendar.DAY_OF_MONTH);

        int afterIndex = iMonth + 1;

        if(iMonth == 13){
            afterIndex = 1;
        }
        mycal = new GregorianCalendar(iYear, beforeIndex, iDay);
        int daysInMonthAfter = mycal.getActualMaximum(Calendar.DAY_OF_MONTH);



        int startingNumber = 0;
        if(startingDay.equals("Sunday")){
            startingNumber = 0;
        }
        else if(startingDay.equals("Monday")){
            startingNumber = 1;
        }
        else if(startingDay.equals("Tuesday")){
            startingNumber = 2;
        }
        else if(startingDay.equals("Wednesday")){
            startingNumber = 3;
        }
        else if(startingDay.equals("Thursday")){
            startingNumber = 4;
        }
        else if(startingDay.equals("Friday")){
            startingNumber = 5;
        }
        else{
            startingNumber = 6;
        }

        for(int i = 0; i < myDays.length; i++){
            TextView temp = (TextView) findViewById(myDays[i]);
//            if(iDay - startingNumber + i < 1){
//                temp.setText(Integer.toString(daysInMonthBefore + (iDay - startingNumber + i)));
//            }//Write Case for Overflow (lazy to think about logic right now)
//            else{
//                temp.setText(Integer.toString(iDay + i - startingNumber));
//            }
            temp.setText(Integer.toString(iDay + i - startingNumber));

        }

        TextView myDay = (TextView) findViewById(R.id.myDate);


        String monthText = new SimpleDateFormat("MMMM").format(mycal.getTime());
        myDay.setText(startingDay + "   " + monthText + " " + day + ", " + year);
    }

    public void toFriends(View v){
        startActivity(new Intent(this, FriendsPageActivity.class));
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
