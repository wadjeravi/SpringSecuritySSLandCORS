package com.shutterfly.cns.service.impl;

import com.shutterfly.cns.dao.NotificationDao;
import com.shutterfly.cns.model.Notification;
import com.shutterfly.cns.service.NotificationService;
import com.shutterfly.cns.util.NotificationMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class NotificationServiceImpl implements NotificationService{

    @Autowired
    private NotificationDao notificationDao;

    @Override
    public Map<String, String> retrieveNotificationsForUser(String userName) {
//        return NotificationMap.getNotificationPerUser(user);
        List<Notification> notificationList = notificationDao.findNotificationByUser(userName);
        Map<String,String> notificationMap = new HashMap<>();
        for(Notification userNotification: notificationList){
            notificationMap.put(userNotification.getSubject(),userNotification.getMessage());
        }
        return notificationMap;

    }
}
