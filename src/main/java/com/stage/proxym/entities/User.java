package com.stage.proxym.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(	name = "users",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "username"),
                @UniqueConstraint(columnNames = "email")
        })
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Temporal(TemporalType.DATE)
    private Date birthDate;
    private Long phoneNum;
    private String address;
    @Enumerated(EnumType.STRING)
    private Role role;
    private String profession;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(	name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Roles> roles = new HashSet<>();

    public User(String username, String email, String password) {
        super();
        this.username = username;
        this.email = email;
        this.password = password;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy="user")
    private List<Expenses> expenses;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="user")
    private List<Income> incomes;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="user")
    private List<Notification> notifications;
}
