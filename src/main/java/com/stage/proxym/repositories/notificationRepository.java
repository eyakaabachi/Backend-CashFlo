package com.stage.proxym.repositories;

import com.stage.proxym.entities.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface notificationRepository extends JpaRepository<Notification, Long> {
}
