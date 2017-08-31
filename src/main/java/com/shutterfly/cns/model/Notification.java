package com.shutterfly.cns.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "Notification")
public class Notification implements Serializable{

    @Id
    @Column(name = "ID")
    private int id;

    @Column(name = "USERNAME",length = 32)
    private String userName;

    @Column(name = "SUBJECT",length = 32)
    private String subject;

    @Column(name = "MESSAGE",length = 32)
    private String message;

    @Column(name = "READ_FLAG")
    private boolean notification_read;

    @Column(name = "START_DATE",length = 15)
    private Date notification_start_date;

    @Column(name = "END_DATE",length = 15)
    private Date notification_end_date;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Notification that = (Notification) o;

        if (notification_read != that.notification_read) return false;
        if (!userName.equals(that.userName)) return false;
        if (!subject.equals(that.subject)) return false;
        if (!message.equals(that.message)) return false;
        if (!notification_start_date.equals(that.notification_start_date)) return false;
        return notification_end_date.equals(that.notification_end_date);
    }

    @Override
    public int hashCode() {
        int result = userName.hashCode();
        result = 31 * result + subject.hashCode();
        result = 31 * result + message.hashCode();
        result = 31 * result + (notification_read ? 1 : 0);
        result = 31 * result + notification_start_date.hashCode();
        result = 31 * result + notification_end_date.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "userName='" + userName + '\'' +
                ", subject='" + subject + '\'' +
                ", message='" + message + '\'' +
                ", notification_read=" + notification_read +
                ", notification_start_date=" + notification_start_date +
                ", notification_end_date=" + notification_end_date +
                '}';
    }
}
