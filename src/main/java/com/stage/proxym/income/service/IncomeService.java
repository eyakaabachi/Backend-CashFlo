package com.stage.proxym.income.service;

import com.stage.proxym.dto.IncomeDto;

import java.util.Date;
import java.util.List;

public interface IncomeService {
    IncomeDto addIncome(IncomeDto i);

    IncomeDto updateIncome(IncomeDto i);

    IncomeDto getIncomeById(long idIncome);

    List<IncomeDto> getAll();

    boolean deleteIncome(long idIncome);

    double totalSumOfIncomePerMonth(Date IncomeStartDate, Date IncomeEndDate);

    String findHighestIncome(Date IncomeStartDate, Date IncomeEndDate);
}
