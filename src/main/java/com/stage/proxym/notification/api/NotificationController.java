package com.stage.proxym.notification.api;

import com.stage.proxym.notification.entity.Notification;
import com.stage.proxym.notification.service.impl.NotificationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("notification")
public class NotificationController {
    @Autowired
    NotificationServiceImpl notifservice;

    @PostMapping("/add")
    public Notification addNotification(@RequestBody Notification notif) {
        return notifservice.addNotification(notif);
    }
    @GetMapping("/getnotification/{idNotification}")
    @ResponseBody
    public Notification getNotificationById(@PathVariable("idNotification") Long idNotification) {
        return notifservice.getNotificationById(idNotification);
    }
    @GetMapping("/retrieve-all-notifs")
    @ResponseBody
    public List<Notification> getCharities() {
        List<Notification> notifs = notifservice.retrieveAllNotification();
        return notifs;}

}
