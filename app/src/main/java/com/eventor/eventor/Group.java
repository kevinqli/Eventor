package com.eventor.eventor;

/**
 * Created by jeffreyzhang on 2/13/16.
 */

import java.util.*;
public class Group {
    public static List<Group> groups_data = new ArrayList<Group>();

    static {
        new Group(
                "Stanford ACM",
                Arrays.asList(0, 1),
                Arrays.asList(0),
                "ACM brings together students with an interest in building cool things with CS.",
                "acm"
        );
        new Group(
                "Stanford Men's Basketball",
                Arrays.asList(0),
                Arrays.asList(1),
                "Check us out on Twitter @Stanfordbball!",
                "stanford"
        );
    }

    public static void addGroup(Group group) {
        groups_data.add(group);
    }

    public static Group getGroup(int id) {
        try {
            return groups_data.get(id);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    public static int getNewId() { return groups_data.size(); }

    private String groupTitle, groupDesc;
    private List<Integer> userList, eventList;
    private String icon;

    private int id;

    public Group() {
        this.groupTitle = "Unnamed Group";
        this.userList = new ArrayList<Integer>();
        this.eventList = new ArrayList<Integer>();
        this.icon = "ic_menu_allfriends";
        this.groupDesc = "";
        this.id = getNewId();
        addGroup(this);
    }
    public Group(String groupTitle, List<Integer> userList, List<Integer> eventList, String groupDesc, String icon) {
        this.groupTitle = groupTitle;
        this.userList = userList;
        this.eventList = eventList;
        this.groupDesc = groupDesc;
        this.icon = icon;
        this.id = getNewId();
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

    public String getIcon() { return icon; }

    public int getId() { return id; }

}

