package com.stage.proxym.controller;

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
    public User addUser(@RequestBody User u) {
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
    @PutMapping("/modifier/{idExp}/{idUser}")
    public void assignExpenseToUser(@PathVariable("idExp") Long idExp, @PathVariable("idUser") Long idUser) {
        iuserservice.assignExpenseToUser(idExp, idUser);
    }
    @PutMapping("/modifier/{idInc}/{idUser}")
    public void assignIncomeToUser(@PathVariable("idInc") Long idInc, @PathVariable("idUser") Long idUser) {
        iuserservice.assignIncomeToUser(idInc, idUser);
    }

    }
