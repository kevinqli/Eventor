
package com.eventor.eventor;
import java.util.Date;
import java.util.*;
/**
 * Created by jeffreyzhang on 2/13/16.
 */
public class Event {

    public static List<Event> events_data = Arrays.asList(new Event[]{
            new Event(
                    "TreeHacks!",
                    "Chillest hackathon.",
                    new Date(2016, 1, 12),
                    new Date(2016, 1, 14),
                    37.43,
                    122.17
            )
    });
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
