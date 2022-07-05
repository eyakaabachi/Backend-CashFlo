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
    private Long IdIncome;
    private String IncomeSource;
    private float IncomeMoney;
    @Temporal(TemporalType.DATE)
    private Date IncomeStartDate;
    @Temporal(TemporalType.DATE)
    private Date IncomeExpireDate;
    private String Description;

    @ManyToOne
    User user;
}
