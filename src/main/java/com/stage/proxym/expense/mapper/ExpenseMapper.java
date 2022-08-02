package com.stage.proxym.expense.mapper;

import com.stage.proxym.dto.ExpenseDto;
import com.stage.proxym.expense.entity.Expense;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ExpenseMapper {


    ModelMapper modelMapper = new ModelMapper();

    public ExpenseDto mapToDto(Expense expense){
        return this.modelMapper.map(expense,ExpenseDto.class);
    }
    public Expense mapToEntity(ExpenseDto expenseDto){
        return this.modelMapper.map(expenseDto,Expense.class);
    }
    public List<ExpenseDto> mapToDtoListExpense (List<Expense> expenses){
        return expenses.stream().map(this::mapToDto).collect(Collectors.toList());
    }
}
