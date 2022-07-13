package com.stage.proxym.services;

import com.stage.proxym.entities.Notification;

import java.util.List;

public interface InotifService {
    public Notification addNotification(Notification notif);
    public Notification getNotificationById(long idNotification);
    public List<Notification> getAll();
    public List<Notification> retrieveAllNotification();
}
