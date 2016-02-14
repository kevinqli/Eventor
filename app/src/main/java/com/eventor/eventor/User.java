package com.eventor.eventor;

/**
 * Created by jeffreyzhang on 2/13/16.
 */
import android.content.Intent;

import java.util.*;
public class User {
    public static ArrayList<User> users_data;

    public static void addUser(User user) {
        users_data.add(user);
    }

    private String userName;
    private ArrayList<Integer> eventList, groupList;
    private ArrayList<User> friendsList;

    public User() {
        this.userName = "Unnamed Person";
        this.eventList = new ArrayList<Integer>();
        this.groupList = new ArrayList<Integer>();
        this.friendsList = new ArrayList<User>();
    }
    public User(String userName, ArrayList<Integer> eventList, ArrayList<Integer> groupList,
                ArrayList<User> friendsList) {
        this.userName = userName;
        this.eventList = eventList;
        this.groupList = groupList;
        this.friendsList = friendsList;
    }

    public void addFriend(User friend) {
        friendsList.add(friend);
    }

    public void addFriend(int friendID) {
        friendsList.add(users_data.get(friendID));
    }
    /* add a group this person is in */
    public void addGroup(int groupID) {
        groupList.add(groupID);
    }
    /* add an event this person wants to attend */
    public void addEvent(int eventID) {
        eventList.add(eventID);
    }

}

