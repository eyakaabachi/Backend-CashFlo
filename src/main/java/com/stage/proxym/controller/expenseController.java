package com.stage.proxym.controller;

import com.stage.proxym.entities.Expenses;
import com.stage.proxym.services.IexpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("expense")
public class expenseController {
    @Autowired
    IexpenseService iexpservice;

    @PostMapping("/add")
    public Expenses addExpense(@RequestBody Expenses ex) {
        return iexpservice.addExpense(ex);
    }
    @DeleteMapping("/deleteidExpense/{idExpense}")
    @ResponseBody
    public void deleteExpense(@PathVariable("idExpense") Long idExpense) {
        iexpservice.deleteExpense(idExpense);
    }

    @PutMapping("/updateExpense")
    @ResponseBody
    public Expenses updateExpenses(@RequestBody Expenses ex) {
        return iexpservice.updateExpense(ex);
    }
    @GetMapping("/getExpense/{idExpense}")
    @ResponseBody
    public Expenses getExpenseById(@PathVariable("idExpense") Long idExpense) {
        return iexpservice.getExpenseById(idExpense);
    }
    @GetMapping("/getsumofexpenses/{expenseStartDate}/{expenseEndDate}")
    @ResponseBody
    public float totalSumOfExpensePerMonth(
            @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd")  Date expenseStartDate,
            @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd")  Date expenseEndDate){
        return iexpservice.totalSumOfExpensePerMonth(expenseStartDate,expenseEndDate);
    }
    @GetMapping("/getremainingcash/{idExpense}")
    @ResponseBody
    public float RemainingCash (@PathVariable("idExpense") Long idExpense){
        return iexpservice.RemainingCash(idExpense);
    }
}
