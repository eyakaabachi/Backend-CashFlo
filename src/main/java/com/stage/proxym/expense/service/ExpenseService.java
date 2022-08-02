package com.stage.proxym.expense.service;

import com.stage.proxym.dto.ExpenseDto;
import com.stage.proxym.expense.entity.Expense;


import java.util.Date;
import java.util.List;

public interface ExpenseService {
    ExpenseDto addExpense(ExpenseDto ex);
    ExpenseDto updateExpense(ExpenseDto ex);
    ExpenseDto getExpenseById(long idExpense);
    List<ExpenseDto> getAll();
    boolean deleteExpense(long idExpense);
    float totalSumOfExpensePerMonth(Date expenseStartDate, Date expenseEndDate);
    float remainingCash (long idExpense);
}
