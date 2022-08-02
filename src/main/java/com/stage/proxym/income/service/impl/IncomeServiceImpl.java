package com.stage.proxym.income.service.impl;

import com.stage.proxym.dto.IncomeDto;
import com.stage.proxym.income.entity.Income;
import com.stage.proxym.income.mapper.IncomeMapper;
import com.stage.proxym.income.service.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import com.stage.proxym.income.repository.IncomeRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class IncomeServiceImpl implements IncomeService {
    @Autowired
    IncomeRepository incomeRepository;
    @Autowired
    IncomeMapper incomeMapper;
    @Override
    public IncomeDto addIncome(IncomeDto i) {
        return incomeMapper.mapToDto(incomeRepository.save(incomeMapper.mapToEntity(i)));
    }

    @Override
    public IncomeDto updateIncome(IncomeDto i) {
        return incomeMapper.mapToDto(incomeRepository.save(incomeMapper.mapToEntity(i)));
    }

    @Override
    public IncomeDto getIncomeById(long idIncome) {
        return incomeMapper.mapToDto(incomeRepository.findById(idIncome).orElse(null));
    }

    @Override
    public List<IncomeDto> getAll() {
        return incomeMapper.mapToDtoListIncome(incomeRepository.findAll());
    }

    @Override
    public boolean deleteIncome(long idIncome) {
       try{
        incomeRepository.deleteById(idIncome);
        return true;
       }catch(DataIntegrityViolationException ex){
           throw new DataIntegrityViolationException(ex.getLocalizedMessage());
       }
    }



    @Override
    public double totalSumOfIncomePerMonth(Date IncomeStartDate, Date IncomeEndDate) {
        List<Income> incomes = (List<Income>) incomeRepository.findAll();
        float summ = 0;
        for (Income income : incomes) {
            if (income.getIncomeStartDate().after(IncomeStartDate) && income.getIncomeEndDate().before(IncomeEndDate)) {
                summ += income.getIncomeMoney();
            }
        }
        return summ;
    }

    @Override
    public String findHighestIncome(Date IncomeStartDate, Date IncomeEndDate) {
        List<Income> incomes = (List<Income>) incomeRepository.findAll();
        List<Float> money = new ArrayList<Float>();
        String source = null;
        for (Income income : incomes) {
            if (income.getIncomeStartDate().after(IncomeStartDate) && income.getIncomeEndDate().before(IncomeEndDate)) {
                money.add(income.getIncomeMoney());
                source = income.getIncomeSource();
            }
        }
        float max = Collections.max(money);
        return "The highest income you received this month is: " + max + " and you received it from: " + source;

    }

}
