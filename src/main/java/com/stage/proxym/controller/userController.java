package com.stage.proxym.controller;

import com.stage.proxym.dto.UserDto;
import com.stage.proxym.entities.User;
import com.stage.proxym.services.IuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class userController {
    @Autowired
    IuserService iuserservice;

    @PostMapping("/add")
    public User addUser(@RequestBody UserDto u) {
          return iuserservice.addUser(u);
    }
    @DeleteMapping("/deleteuser/{idUser}")
    @ResponseBody
    public void deleteUser(@PathVariable("idUser") Long idUser) {
        iuserservice.deleteUser(idUser);
    }

    @PutMapping("/updateuser")
    @ResponseBody
    public User updateUser(@RequestBody User u) {
        return iuserservice.updateUser(u);
    }

    @PutMapping("/assignexpense/{idExp}/{idUser}")
    public void assignExpenseToUser(@PathVariable("idExp") Long idExp, @PathVariable("idUser") Long idUser) {
        iuserservice.assignExpenseToUser(idExp, idUser);
    }
    @PutMapping("/assignincome/{idInc}/{idUser}")
    public void assignIncomeToUser(@PathVariable("idInc") Long idInc, @PathVariable("idUser") Long idUser) {
        iuserservice.assignIncomeToUser(idInc, idUser);
    }
    @GetMapping("/getuser/{idUser}")
    @ResponseBody
    public User getUserById(@PathVariable("idUser") Long idUser) {
        return iuserservice.getUserById(idUser);
    }

    }
