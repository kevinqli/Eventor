package com.eventor.eventor;

/**
 * Created by jeffreyzhang on 2/13/16.
 */
import android.content.Intent;
import android.graphics.Picture;
import android.widget.ImageView;

import java.util.*;
public class User {

    public static int me = 0;

    public static List<User> users_data = new ArrayList<User>();

    static {
        new User(
                "Kevin Li",
                Arrays.asList(0, 1),
                Arrays.asList(0, 1),
                Arrays.asList(1),
                "kevinliimage"
        );
        new User(
                "Jeffrey Zhang",
                Arrays.asList(0),
                Arrays.asList(0, 1),
                Arrays.asList(0),
                "jeffreyzhangimage"
        );
    }

    private String userName;
    private List<Integer> eventList, groupList;
    private List<Integer> friendsList;
    private String image;
    private final int id;

    public static User getUser(int id) {
        try {
            return users_data.get(id);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    public static int getNewId() {
        return users_data.size();
    }

    public static void addUser(User user) {
        users_data.add(user);
    }

    public User() {
        this.userName = "Unnamed Person";
        this.eventList = new ArrayList<Integer>();
        this.groupList = new ArrayList<Integer>();
        this.friendsList = new ArrayList<Integer>();
        this.image = "profilepicture";
        this.id = getNewId();
        addUser(this);
    }
    public User(String userName, List<Integer> eventList, List<Integer> groupList,
                List<Integer> friendsList, String image) {
        this.userName = userName;
        this.eventList = eventList;
        this.groupList = groupList;
        this.friendsList = friendsList;
        this.image = image;
        this.id = getNewId();
        addUser(this);
    }

    public String getUserName() {
        return userName;
    }

    public List<Integer> getEventList() {
        return eventList;
    }

    public List<Integer> getGroupList() {
        return groupList;
    }

    public List<Integer> getFriendsList() {
        return friendsList;
    }

    public String getImage() {
        return image;
    }

    public int getId() {
        return id;
    }

    public void addFriend(int friendID) {
        friendsList.add(friendID);
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

