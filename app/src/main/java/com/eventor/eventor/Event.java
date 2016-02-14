
package com.eventor.eventor;
import java.util.Date;
import java.util.*;
/**
 * Created by jeffreyzhang on 2/13/16.
 */
public class Event {

    public static ArrayList<Event> events_data;
    /*
            new Event("TreeHacks","Best hackathon ever", new Date(2016,2,12,23,0)
                    , new Date(2016,2,14,11,0), 25, 25)
    */
    public static void addEvent(Event event) {
        events_data.add(event);
    }
    private String eventName, eventDesc;
    private Date eventStart, eventEnd;
    private double latitude, longitude;

    private static final int HALF_DAY = 12, MINUTES_IN_HOUR = 60;

    public Event() {
        this.eventName = "Unnamed Event";
        this.eventStart = new Date();
        this.eventEnd = new Date();
    }
    public Event(String eventName, String eventDesc,
                 Date eventStart, Date eventEnd, double latitude, double longitude) {
        this.eventName = eventName;
        this.eventDesc = eventDesc;
        this.eventStart = eventStart;
        this.eventEnd = eventEnd;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    private void setLocation(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    private void setName(String eventName) {
        this.eventName = eventName;
    }
}
