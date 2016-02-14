package com.eventor.eventor;
import java.util.*;
/**
 * Created by jeffreyzhang on 2/13/16.
 */
public class Utility {
    private static final int MINUTES_IN_DAY = 24*60, HALF_HOUR = 30;
    public static int[] getFrequencies(List<Integer> users, Date query) {
        int ret[] = new int[MINUTES_IN_DAY/HALF_HOUR];

        for(Integer id : users) {
            User curUser = User.users_data.get(id);
            int tmp[] = new int[ret.length];
            for(Integer id2 : curUser.getEventList()) {
                Event curEvent = Event.events_data.get(id2);
                Date begin = curEvent.getEventStart();
                Date end = curEvent.getEventEnd();

                if(end.getDay() < query.getDay()) continue;
                if(begin.getDay() > query.getDay()) continue;

                int idx1 = (begin.getHours() * 60 + begin.getMinutes()) / 30;
                if(begin.getDay() < query.getDay())
                    idx1 = 0;
                int idx2 = (end.getHours() * 60 + end.getMinutes()) / 30;
                if(end.getDay() > query.getDay())
                    idx2 = ret.length - 1;
                tmp[idx1]++;
                if(idx2 + 1 < ret.length) {
                    tmp[idx2 + 1]--;
                }
            }
            for(int i = 0; i < ret.length; i++) {
                if(tmp[i] > 0) ret[i] = 1;
                if(tmp[i] < 0) ret[i] = -1;
            }
        }
        for(int i = 0; i < ret.length; i++) {
            ret[i] = ret[i-1] + ret[i];
        }
        return ret;
    }
}
