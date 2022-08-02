package com.stage.proxym.income.mapper;

import com.stage.proxym.dto.IncomeDto;
import com.stage.proxym.dto.UserDto;
import com.stage.proxym.income.entity.Income;
import com.stage.proxym.user.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class IncomeMapper {
    ModelMapper modelMapper = new ModelMapper();

    public IncomeDto mapToDto(Income income){
        return this.modelMapper.map(income,IncomeDto.class);
    }
    public Income mapToEntity(IncomeDto incomeDto){
        return this.modelMapper.map(incomeDto,Income.class);
    }

    public List<IncomeDto> mapToDtoListIncome (List<Income> incomes){
        return incomes.stream().map(this::mapToDto).collect(Collectors.toList());
    }
}
