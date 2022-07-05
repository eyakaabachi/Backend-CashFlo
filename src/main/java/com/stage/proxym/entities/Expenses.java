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
    private Long IdExpense;
    @Enumerated(EnumType.STRING)
    private Type type;
    private float ExpenseCash;
    private Date ExpenseExpireDate;
    private Boolean ExpensePayment;
    private float ExpensePrice;
    private Date ExpenseRegistrationDate;

    @ManyToOne
    User user;
}
