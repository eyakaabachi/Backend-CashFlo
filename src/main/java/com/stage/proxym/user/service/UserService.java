package com.stage.proxym.user.service;

import com.stage.proxym.dto.UserDto;
import com.stage.proxym.user.entity.User;

import java.util.List;

public interface UserService {
     UserDto addUser(UserDto u);
     UserDto updateUser(UserDto u);
     UserDto getUserById(long idUser);
     List<UserDto> getAll();
     boolean deleteUser(long idUser);
     User assignExpenseToUser(Long idExp, Long idUser);
     User assignIncomeToUser(Long idInc, Long idUser);


}
