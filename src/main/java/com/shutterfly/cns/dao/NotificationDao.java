package com.shutterfly.cns.dao;

import com.shutterfly.cns.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationDao extends JpaRepository<Notification, String> {

    @Query("select p from Notification p where p.userName=?1")
    List<Notification> findNotificationByUser(String userName);
}
