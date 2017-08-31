package com.shutterfly.cns.service;

import java.util.Map;

public interface NotificationService {
    Map<String, String> retrieveNotificationsForUser(String userName);
}
