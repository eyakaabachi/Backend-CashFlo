package com.stage.proxym.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Data
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;
    private String firstName;
    private String lastName;
    private String email;
    private String passwd;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Temporal(TemporalType.DATE)
    private Date birthDate;
    private Long phoneNum;
    private String address;
    @Enumerated(EnumType.STRING)
    private Role role;
    private String profession;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="user")
    private List<Expenses> expenses;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="user")
    private List<Income> incomes;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="user")
    private List<Notification> notifications;
}
