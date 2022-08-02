package com.stage.proxym.user.api;

import com.stage.proxym.dto.UserDto;
import com.stage.proxym.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/")
    public UserDto addUser(@RequestBody UserDto u) {
        return userService.addUser(u);
    }

    @DeleteMapping("/{idUser}")
    @ResponseBody
    public boolean deleteUser(@PathVariable("idUser") Long idUser) {
        userService.deleteUser(idUser);
        return true;
    }

    @PutMapping("/")
    @ResponseBody
    public UserDto updateUser(@RequestBody UserDto u) {
        return userService.updateUser(u);
    }

    @GetMapping("/{idUser}")
    @ResponseBody
    public UserDto getUserById(@PathVariable("idUser") Long idUser) {
        return userService.getUserById(idUser);
    }

    @PutMapping("/assignexpense/{idExp}/{idUser}")
    public void assignExpenseToUser(@PathVariable("idExp") Long idExp, @PathVariable("idUser") Long idUser) {
        userService.assignExpenseToUser(idExp, idUser);
    }

    @PutMapping("/assignincome/{idInc}/{idUser}")
    public void assignIncomeToUser(@PathVariable("idInc") Long idInc, @PathVariable("idUser") Long idUser) {
        userService.assignIncomeToUser(idInc, idUser);
    }
}