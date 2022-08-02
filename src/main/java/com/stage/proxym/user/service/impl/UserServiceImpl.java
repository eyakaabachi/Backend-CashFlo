package com.stage.proxym.user.service.impl;

import com.stage.proxym.dto.IncomeDto;
import com.stage.proxym.dto.UserDto;
import com.stage.proxym.expense.entity.Expense;
import com.stage.proxym.income.entity.Income;
import com.stage.proxym.user.entity.User;
import com.stage.proxym.user.mapper.UserMapper;
import com.stage.proxym.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import com.stage.proxym.user.repository.UserRepository;
import com.stage.proxym.expense.repository.ExpenseRepository;
import com.stage.proxym.income.repository.IncomeRepository;

import java.util.List;
import java.util.Set;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    ExpenseRepository expenseRepository;
    @Autowired
    IncomeRepository incomeRepository;
    @Autowired
    UserMapper userMapper;

    @Override
    public UserDto addUser(UserDto u) {
        return userMapper.mapToDto(userRepository.save(userMapper.mapToEntity(u)));
    }

    @Override
    public UserDto updateUser(UserDto u) {
        return userMapper.mapToDto(userRepository.save(userMapper.mapToEntity(u)));
    }

    @Override
    public UserDto getUserById(long idUser) {

        return userMapper.mapToDto(userRepository.findById(idUser).orElse(null));
    }

    @Override
    public List<UserDto> getAll() {
        return userMapper.mapToDtoListUser(userRepository.findAll());

    }

    @Override
    public boolean deleteUser(long idUser) {
        try{
            userRepository.deleteById(idUser);
            return true;
        }catch(DataIntegrityViolationException ex){
            throw new DataIntegrityViolationException(ex.getLocalizedMessage());
        }
    }

    @Override
    public User assignExpenseToUser(Long idExp, Long idUser) {
        User user = userRepository.findById(idUser).orElse(null);
        Expense expense  = expenseRepository.findById(idExp).orElse(null);
        expense.setUser(user);
        user.getExpenses().add(expense);
        return userRepository.save(user);
//        Expenses expense = expenseRepo.findById(Long.valueOf(idExp)).orElse(null);
//        Set<ExpenseDto> list = null;
//        ExpenseDto expenseDto = modelMapper.map(expense,ExpenseDto.class);
//        list.add(expenseDto);
//        User user = userRepo.findById(Long.valueOf(idUser)).orElse(null);
//        UserDto userDto = modelMapper.map(user,UserDto.class);
//        userDto.setExpenseDtoSet(list);
//        return userRepo.save(modelMapper.map(userDto, User.class));
    }


    @Override
    public User assignIncomeToUser(Long idInc, Long idUser) {
        User user = userRepository.findById(idUser).orElse(null);
        Income income  = incomeRepository.findById(idInc).orElse(null);
        income.setUser(user);
        user.getIncomes().add(income);
        return userRepository.save(user);
    }







}
