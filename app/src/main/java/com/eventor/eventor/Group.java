package com.eventor.eventor;

/**
 * Created by jeffreyzhang on 2/13/16.
 */
import android.content.Intent;

import java.util.*;
public class Group {
    public static List<Group> groups_data;

    public static void addGroup(Group group) {
        groups_data.add(group);
    }

    public static Group getGroup(int id) { return groups_data.get(id); }

    public static int getId() { return groups_data.size(); }

    private String groupTitle, groupDesc;
    private List<Integer> userList, eventList;
    private int id;

    public Group() {
        this.groupTitle = "Unnamed Group";
        this.userList = new ArrayList<Integer>();
        this.eventList = new ArrayList<Integer>();
        this.groupDesc = "";
        this.id = getId();
        addGroup(this);
    }
    public Group(String groupTitle, List<Integer> userList, List<Integer> eventList, String groupDesc) {
        this.groupTitle = groupTitle;
        this.userList = userList;
        this.eventList = eventList;
        this.groupDesc = groupDesc;
        this.id = getId();
        addGroup(this);
    }
    /* add an event to the group to host */
    public void addEvent(int eventID) {
        eventList.add(eventID);
    }
    /* add a user to this group (user subscribes) */
    public void addUser(int userID) {
        userList.add(userID);
    }

    public String getGroupTitle() { return groupTitle; }

    public String getGroupDesc() { return groupDesc; }

    public List<Integer> getUserList() { return userList; }

    public List<Integer> getEventList() { return eventList; }

}

