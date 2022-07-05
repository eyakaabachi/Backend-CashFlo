package com.stage.proxym.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IdUser;
    private String FirstName;
    private String LastName;
    private String Email;
    private String Passwd;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private Date BirthDate;
    private Long PhoneNum;
    private String Address;
    @Enumerated(EnumType.STRING)
    private Role role;
    private String Profession;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="user")
    private List<Expenses> expenses;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="user")
    private List<Income> incomes;
}
