package com.stage.proxym.controller;

import com.stage.proxym.entities.Notification;
import com.stage.proxym.services.NotifService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("notification")
public class notificationController {
    @Autowired
    NotifService notifservice;

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
    public List<Notification> getcharities() {
        List<Notification> notifs = notifservice.retrieveAllNotification();
        return notifs;}

}
