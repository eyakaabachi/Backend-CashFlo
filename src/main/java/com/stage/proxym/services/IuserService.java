package com.stage.proxym.services;

import com.stage.proxym.dto.UserDto;
import com.stage.proxym.entities.User;

import java.util.List;

public interface IuserService {
    public User addUser(UserDto u);
    public User updateUser(User u);
    public User getUserById(long idUser);
    public List<User> getAll();
    public void deleteUser(long idUser);
    public User assignExpenseToUser(Long idExp, Long idUser);
    public User assignIncomeToUser(Long idInc, Long idUser);
    public List<User> retrieveAllUser();

}
