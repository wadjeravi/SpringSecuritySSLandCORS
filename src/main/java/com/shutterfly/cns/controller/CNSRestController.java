package com.shutterfly.cns.controller;

import com.shutterfly.cns.model.UserData;
import com.shutterfly.cns.service.NotificationService;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.Produces;

@RestController
public class CNSRestController {

    private static final Logger log = LoggerFactory
            .getLogger(CNSRestController.class);

    @Autowired
    public NotificationService notificationService;

    @RequestMapping("/")
    public String welcome(){
        return "welcome";
    }

    @RequestMapping(value = "/cns/notification", method = RequestMethod.POST)
    public String readNotificationPerUser(@RequestBody UserData userData){
        JSONObject json = new JSONObject(notificationService.retrieveNotificationsForUser(userData.userName));
        return json.toString();
    }

}
