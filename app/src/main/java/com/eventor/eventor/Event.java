
package com.eventor.eventor;
import java.util.Date;
import java.util.*;
/**
 * Created by jeffreyzhang on 2/13/16.
 */
public class Event {

    public static List<Event> events_data = new ArrayList<Event>();

    static {
        new Event(
                "TreeHacks!",
                "Chillest hackathon.",
                new Date(2016, 1, 12, 8, 0),
                new Date(2016, 1, 12, 19, 30),
                37.4279209,
                -122.1764832
        );
        new Event(
                "Men's Basketball vs. USC",
                "Buy your tickets!",
                new Date(2016, 1, 25),
                new Date(2016, 1, 25),
                37.4295915,
                -122.1627275
        );
    }
    public static int getNewId() {
        return events_data.size();
    }
    public static void addEvent(Event event) {
        events_data.add(event);
    }
    public static Event getEvent(int id) { return events_data.get(id); }
    private String eventName, eventDesc;
    private Date eventStart, eventEnd;
    private double latitude, longitude;
    private int id;

    private static final int HALF_DAY = 12, MINUTES_IN_HOUR = 60;

    public Event() {
        this.eventName = "Unnamed Event";
        this.eventDesc = "";
        this.eventStart = new Date();
        this.eventEnd = new Date();
        id = getNewId();
        events_data.add(this);
    }
    public Event(String eventName, String eventDesc,
                 Date eventStart, Date eventEnd, double latitude, double longitude) {
        this.eventName = eventName;
        this.eventDesc = eventDesc;
        this.eventStart = eventStart;
        this.eventEnd = eventEnd;
        this.latitude = latitude;
        this.longitude = longitude;
        id = getNewId();
        events_data.add(this);
    }

    public String getEventName() {
        return eventName;
    }

    public String getEventDesc() {
        return eventDesc;
    }

    public Date getEventStart() {
        return eventStart;
    }

    public Date getEventEnd() { return eventEnd; }

    public double getLatitude() { return latitude; }

    public double getLongitude() { return longitude; }

    public void setLocation(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }



    public void setName(String eventName) {
        this.eventName = eventName;
    }
}
