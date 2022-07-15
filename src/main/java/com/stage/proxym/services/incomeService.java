package com.stage.proxym.services;

import com.stage.proxym.entities.Income;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.stage.proxym.repositories.IncomeRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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
        List<Income> incomes = (List<Income>) incomeRepo.findAll();
        return incomes;
    }

    @Override
    public float totalSumOfIncomePerMonth(Date IncomeStartDate, Date IncomeEndDate) {
        List<Income> incomes = (List<Income>) incomeRepo.findAll();
        float summ = 0;
        for (Income income : incomes) {
            if (income.getIncomeStartDate().after(IncomeStartDate) && income.getIncomeEndDate().before(IncomeEndDate)) {
                summ += income.getIncomeMoney();
            }
        }
        return summ;
    }

    @Override
    public void findHighestIncome(long idIncome, Date IncomeStartDate, Date IncomeEndDate) {
        List<Income> incomes = (List<Income>) incomeRepo.findAll();
        List<Float> money = new ArrayList<Float>();
        String source = null;
        for (Income income : incomes) {
            if (income.getIncomeStartDate().after(IncomeStartDate) && income.getIncomeEndDate().before(IncomeEndDate)) {
                money.add(income.getIncomeMoney());
                source = income.getIncomeSource();
            }
        }
        float max = Collections.max(money);
        System.out.println("The highest income you received this month is: " + max + "and you received it from: " + source);

    }

}
