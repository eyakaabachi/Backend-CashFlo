package com.stage.proxym.services;

import com.stage.proxym.entities.Expenses;


import java.util.Date;
import java.util.List;

public interface IexpenseService {
    public Expenses addExpense(Expenses ex);
    public Expenses updateExpense(Expenses ex);
    public Expenses getExpenseById(long idExpense);
    public List<Expenses> getAll();
    public void deleteExpense(long idExpense);
    public List<Expenses> retrieveAllExpenses();
    public float totalSumOfExpensePerMonth(Date expenseStartDate, Date expenseEndDate);
    public float RemainingCash (long idExpense);
}
