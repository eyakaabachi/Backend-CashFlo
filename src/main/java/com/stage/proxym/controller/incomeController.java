package com.stage.proxym.controller;

import com.stage.proxym.entities.Income;
import com.stage.proxym.entities.User;
import com.stage.proxym.services.IincomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("income")
public class incomeController {
    @Autowired
    IincomeService iincomeservice;

    @PostMapping("/add")
    public Income addIncome(@RequestBody Income i) {
        return iincomeservice.addIncome(i);
    }
    @DeleteMapping("/deleteIncome/{idIncome}")
    @ResponseBody
    public void deleteIncome(@PathVariable("idIncome") Long idIncome) {
        iincomeservice.deleteIncome(idIncome);
    }

    @PutMapping("/updateIncome")
    @ResponseBody
    public Income updateIncome(@RequestBody Income i) {
        return iincomeservice.updateIncome(i);
    }
    @GetMapping("/getincome/{idIncome}")
    @ResponseBody
    public Income getIncomeById(@PathVariable("idIncome") Long idIncome) {
        return iincomeservice.getIncomeById(idIncome);
    }
    @GetMapping("/getsumofincomes/{expenseStartDate}/{expenseEndDate}")
    @ResponseBody
    public float totalSumOfIncomePerMonth(
            @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date expenseStartDate,
            @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd")  Date expenseEndDate){
        return iincomeservice.totalSumOfIncomePerMonth(expenseStartDate,expenseEndDate);
    }
    @GetMapping("/gethighestincome/{idIncome}/{expenseStartDate}/{expenseEndDate}")
    @ResponseBody
    public void findHighestIncome(@PathVariable("idIncome") Long idIncome,
                                  @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date expenseStartDate,
                                  @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd")  Date expenseEndDate) {
        iincomeservice.findHighestIncome(idIncome,expenseStartDate,expenseEndDate);
    }
}
