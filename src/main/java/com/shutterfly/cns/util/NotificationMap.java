package com.shutterfly.cns.util;

import java.util.HashMap;
import java.util.Map;

public enum NotificationMap {
    A("MPT Team", "Notification for MPT Team"),
    B("PPT Team", "Notification for PPT Team"),
    C("CT Team",  "Notification for CT Team");

    private final String subject;
    private final String message;

    NotificationMap(String message, String subject){
        this.subject = subject;
        this.message = message;
    }

    public static Map<String,String> getNotificationPerUser(String user){
        Map<String, String> nMap = new HashMap<>();
        for(NotificationMap s : NotificationMap.values()){
            if(s.name().equalsIgnoreCase(user)){
                nMap.put(s.subject,s.message);
            }
        }
        return nMap;
    }

}
