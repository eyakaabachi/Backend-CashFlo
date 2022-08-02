package com.stage.proxym.notification.service.impl;

import com.stage.proxym.notification.entity.Notification;
import com.stage.proxym.notification.repository.NotificationRepository;
import com.stage.proxym.notification.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    NotificationRepository notifrepo;
    @Override
    public Notification addNotification(Notification notif) {
        return notifrepo.save(notif);
    }

    @Override
    public Notification getNotificationById(long idNotification) {
        return notifrepo.findById(idNotification).orElse(null);
    }

    @Override
    public List<Notification> getAll() {
        return notifrepo.findAll();
    }

    @Override
    public List<Notification> retrieveAllNotification() {
        List<Notification> notifications = (List<Notification>)notifrepo.findAll();
        return notifications;
    }
}
