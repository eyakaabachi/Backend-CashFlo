package com.stage.proxym.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
public class Income implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idIncome;
    private String incomeSource;
    private float incomeMoney;
    @Temporal(TemporalType.DATE)
    private Date incomeStartDate;
    @Temporal(TemporalType.DATE)
    private Date incomeExpireDate;
    private String description;

    @ManyToOne
    User user;
}
