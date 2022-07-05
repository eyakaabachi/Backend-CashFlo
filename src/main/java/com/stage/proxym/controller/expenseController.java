package com.stage.proxym.controller;

import com.stage.proxym.entities.Expenses;
import com.stage.proxym.entities.Income;
import com.stage.proxym.services.IexpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("expense")
public class expenseController {
    @Autowired
    IexpenseService iexpservice;

    @PostMapping("/add")
    public Expenses addExpense(@RequestBody Expenses ex) {
        return iexpservice.addExpense(ex);
    }
    @DeleteMapping("/deleteIncome/{idIncome}")
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
}
