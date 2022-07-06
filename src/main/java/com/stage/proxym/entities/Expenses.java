package com.stage.proxym.entities;

import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
public class Expenses  implements Serializable {
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

    @ManyToOne
    User user;
}
