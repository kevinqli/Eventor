package com.eventor.eventor;

/**
 * Created by jeffreyzhang on 2/13/16.
 */
import android.content.Intent;

import java.util.*;
public class Group {
    public static ArrayList<Group> groups_data;

    public static void addGroup(Group group) {
        groups_data.add(group);
    }

    private String groupTitle, groupDesc;
    private ArrayList<Integer> userList, eventList;

    public Group() {
        this.groupTitle = "Unnamed Group";
        this.userList = new ArrayList<Integer>();
        this.eventList = new ArrayList<Integer>();
    }
    public Group(String groupTitle, ArrayList<Integer> userList, ArrayList<Integer> eventList, String groupDesc) {
        this.groupTitle = groupTitle;
        this.userList = userList;
        this.eventList = eventList;
        this.groupDesc = groupDesc;
    }
    /* add an event to the group to host */
    public void addEvent(int eventID) {
        eventList.add(eventID);
    }
    /* add a user to this group (user subscribes) */
    public void addUser(int userID) {
        userList.add(userID);
    }

}

