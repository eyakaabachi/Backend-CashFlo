package com.stage.proxym.dto;

import com.stage.proxym.expense.entity.Type;
import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ExpenseDto {
    private long idExpense;
    private Type type;
    private float expenseCash;
    private Date expenseExpireDate;
    private Boolean expensePayment;
    private float expensePrice;
    private Date expenseRegistrationDate;
}
