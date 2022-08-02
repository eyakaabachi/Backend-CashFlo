package com.stage.proxym.expense.entity;

import com.stage.proxym.user.entity.User;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
public class Expense implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long idExpense;
    @Enumerated(EnumType.STRING)
    private Type type;
    private float expenseCash;
    @Temporal(TemporalType.DATE)
    private Date expenseExpireDate;
    private Boolean expensePayment;
    private float expensePrice;
    @Temporal(TemporalType.DATE)
    private Date expenseRegistrationDate;
    @Temporal(TemporalType.DATE)
    private Date expenseEndDate;

    @ManyToOne
    User user;
}
