package com.stage.proxym.expense.service.impl;

import com.stage.proxym.dto.ExpenseDto;
import com.stage.proxym.expense.entity.Expense;
import com.stage.proxym.expense.mapper.ExpenseMapper;
import com.stage.proxym.expense.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import com.stage.proxym.expense.repository.ExpenseRepository;

import java.util.Date;
import java.util.List;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    @Autowired
    ExpenseRepository expenseRepository;
    @Autowired
    ExpenseMapper expenseMapper;

    @Override
    public ExpenseDto addExpense(ExpenseDto ex) {
        return expenseMapper.mapToDto(expenseRepository.save(expenseMapper.mapToEntity(ex)));
    }

    @Override
    public ExpenseDto updateExpense(ExpenseDto ex) {
        return expenseMapper.mapToDto(expenseRepository.save(expenseMapper.mapToEntity(ex)));
    }

    @Override
    public ExpenseDto getExpenseById(long idExpense) {
        return expenseMapper.mapToDto(expenseRepository.findById(idExpense).orElse(null));
    }

    @Override
    public List<ExpenseDto> getAll() {
        return expenseMapper.mapToDtoListExpense(expenseRepository.findAll());
    }

    @Override
    public boolean deleteExpense(long idExpense) {
        try{
            expenseRepository.deleteById(idExpense);
            return true;
        }catch(DataIntegrityViolationException ex){
            throw new DataIntegrityViolationException(ex.getLocalizedMessage());
        }
    }


    @Override
    public float totalSumOfExpensePerMonth(Date expenseStartDate, Date expenseEndDate) {
        List<Expense> exps = (List<Expense>) expenseRepository.findAll();
        float summ = 0;
        for (Expense exp : exps) {
            if (exp.getExpenseRegistrationDate().after(expenseStartDate) && exp.getExpenseEndDate().before(expenseEndDate)) {
                summ += exp.getExpenseCash();
            }
        }
        return summ;
    }
    @Override
    public float remainingCash (long idExpense) {
        Expense exp = expenseRepository.findById(idExpense).orElse(null);
        float cash = 0;
        if (exp.getExpenseCash() > exp.getExpensePrice()) {
            cash = exp.getExpensePrice() - exp.getExpenseCash();
        }
        return cash;
    }

}
