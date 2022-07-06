package com.stage.proxym.services;

import com.stage.proxym.dto.ExpenseDto;
import com.stage.proxym.dto.UserDto;
import com.stage.proxym.entities.Expenses;
import com.stage.proxym.entities.Income;
import com.stage.proxym.entities.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.stage.proxym.repositories.userRepository;
import com.stage.proxym.repositories.expenseRepository;
import com.stage.proxym.repositories.incomeRepository;

import java.util.List;
import java.util.Set;


@Service
public class userService implements IuserService {

    @Autowired
    userRepository userRepo;
    @Autowired
    expenseRepository expenseRepo;
    @Autowired
    incomeRepository incomeRepo;

    ModelMapper modelMapper = new ModelMapper();

    @Override
    public User addUser(UserDto u) {

        User user = modelMapper.map(u,User.class);
        return userRepo.save(user);
    }

    @Override
    public User updateUser(User u) {
        return userRepo.save(u);
    }

    @Override
    public User getUserById(long idUser) {

        return userRepo.findById(idUser).orElse(null);
    }

    @Override
    public List<User> getAll() {
        return userRepo.findAll();

    }

    @Override
    public void deleteUser(long idUser) {
        userRepo.deleteById(idUser);
    }

    @Override
    public User assignExpenseToUser(Long idExp, Long idUser) {
        User user = userRepo.findById(idUser).orElse(null);
        Expenses expense  = expenseRepo.findById(idExp).orElse(null);
        expense.setUser(user);
        user.getExpenses().add(expense);
        return userRepo.save(user);
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
        User user = userRepo.findById(idUser).orElse(null);
        Income income  = incomeRepo.findById(idInc).orElse(null);
        income.setUser(user);
        user.getIncomes().add(income);
        return userRepo.save(user);
    }

    @Override
    public List<User> retrieveAllUser() {
        List<User> users = (List<User>)userRepo.findAll();
        return users;
    }






}
