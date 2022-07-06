package com.stage.proxym.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
public class Notification implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idNotif;
    private String description;
    @Temporal(TemporalType.DATE)
    private Date SendingDate;

    @ManyToOne
    User user;
}
