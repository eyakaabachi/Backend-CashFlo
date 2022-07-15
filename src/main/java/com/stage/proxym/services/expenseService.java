package com.stage.proxym.services;

import com.stage.proxym.entities.Expenses;
import com.stage.proxym.entities.Income;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.stage.proxym.repositories.ExpenseRepository;

import java.util.Date;
import java.util.List;

@Service
public class expenseService implements IexpenseService {

    @Autowired
    ExpenseRepository expenseRepo;

    @Override
    public Expenses addExpense(Expenses ex) {
        return expenseRepo.save(ex);
    }

    @Override
    public Expenses updateExpense(Expenses ex) {
        return expenseRepo.save(ex);
    }

    @Override
    public Expenses getExpenseById(long idExpense) {
        return expenseRepo.findById(idExpense).orElse(null);
    }

    @Override
    public List<Expenses> getAll() {
        return expenseRepo.findAll();
    }

    @Override
    public void deleteExpense(long idExpense) {
        expenseRepo.deleteById(idExpense);
    }

    @Override
    public List<Expenses> retrieveAllExpenses() {
        List<Expenses> exps = (List<Expenses>)expenseRepo.findAll();
        return exps;
    }
    @Override
    public float totalSumOfExpensePerMonth(Date expenseStartDate, Date expenseEndDate) {
        List<Expenses> exps = (List<Expenses>)expenseRepo.findAll();
        float summ = 0;
        for (Expenses exp : exps) {
            if (exp.getExpenseRegistrationDate().after(expenseStartDate) && exp.getExpenseEndDate().before(expenseEndDate)) {
                summ += exp.getExpensePrice();
            }
        }
        return summ;
    }
    @Override
    public float RemainingCash (long idExpense) {
        Expenses exp = expenseRepo.findById(idExpense).orElse(null);
        float cash = 0;
        if (exp.getExpenseCash() > exp.getExpensePrice()) {
            cash = exp.getExpensePrice() - exp.getExpenseCash();
        }
        return cash;
    }

}
