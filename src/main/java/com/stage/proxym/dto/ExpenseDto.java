package com.stage.proxym.dto;

import com.stage.proxym.entities.Type;
import lombok.Data;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Data
public class ExpenseDto {
    private Type type;
    private float expenseCash;
    private Date expenseExpireDate;
    private Boolean expensePayment;
    private float expensePrice;
    private Date expenseRegistrationDate;
}
