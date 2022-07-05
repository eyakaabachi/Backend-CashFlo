package com.stage.proxym.services;

import com.stage.proxym.entities.Expenses;
import com.stage.proxym.entities.Income;
import com.stage.proxym.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.stage.proxym.repositories.userRepository;
import com.stage.proxym.repositories.expenseRepository;
import com.stage.proxym.repositories.incomeRepository;

import java.util.List;


@Service
public class userService implements IuserService {

    @Autowired
    userRepository userRepo;
    @Autowired
    expenseRepository expenseRepo;
    @Autowired
    incomeRepository incomeRepo;

    @Override
    public User addUser(User u) {
        return userRepo.save(u);
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
