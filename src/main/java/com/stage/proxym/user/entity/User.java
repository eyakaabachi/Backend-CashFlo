package com.stage.proxym.user.entity;

import com.stage.proxym.notification.entity.*;
import com.stage.proxym.expense.entity.Expense;
import com.stage.proxym.income.entity.Income;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(	name = "user",
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
    private ERole role;
    private String profession;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(	name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public User(String username, String email, String password) {
        super();
        this.username = username;
        this.email = email;
        this.password = password;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy="user")
    private List<Expense> expenses;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="user")
    private List<Income> incomes;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="user")
    private List<Notification> notifications;

    public User() {
        super();
    }
}
