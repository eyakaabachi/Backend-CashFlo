package com.stage.proxym.services;

import com.stage.proxym.entities.Income;
import com.stage.proxym.entities.Notification;
import com.stage.proxym.repositories.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class NotifService implements InotifService {

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
