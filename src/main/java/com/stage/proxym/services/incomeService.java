package com.stage.proxym.services;

import com.stage.proxym.entities.Income;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.stage.proxym.repositories.IncomeRepository;

import java.util.List;

@Service
public class incomeService implements IincomeService {
    @Autowired
    IncomeRepository incomeRepo;

    @Override
    public Income addIncome(Income i) {
        return incomeRepo.save(i);
    }

    @Override
    public Income updateIncome(Income i) {
        return incomeRepo.save(i);
    }

    @Override
    public Income getIncomeById(long idIncome) {
        return incomeRepo.findById(idIncome).orElse(null);
    }

    @Override
    public List<Income> getAll() {
        return incomeRepo.findAll();
    }

    @Override
    public void deleteIncome(long idIncome) {
        incomeRepo.deleteById(idIncome);
    }

    @Override
    public List<Income> retrieveAllIncomes() {
        List<Income> incomes = (List<Income>)incomeRepo.findAll();
        return incomes;
    }
}
