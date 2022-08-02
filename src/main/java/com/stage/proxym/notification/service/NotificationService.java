package com.stage.proxym.notification.service;

import com.stage.proxym.notification.entity.Notification;

import java.util.List;

public interface NotificationService {
     Notification addNotification(Notification notif);
     Notification getNotificationById(long idNotification);
     List<Notification> getAll();
     List<Notification> retrieveAllNotification();
}
