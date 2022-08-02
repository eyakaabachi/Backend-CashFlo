package com.stage.proxym.expense.api;

import com.stage.proxym.dto.ExpenseDto;
import com.stage.proxym.expense.entity.Expense;
import com.stage.proxym.expense.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("expense")
public class ExpenseController {
    @Autowired
    ExpenseService expenseService;

    @PostMapping("/")
    public ExpenseDto addExpense(@RequestBody ExpenseDto ex) {
        return expenseService.addExpense(ex);
    }

    @DeleteMapping("/{idExpense}")
    @ResponseBody
    public boolean deleteExpense(@PathVariable("idExpense") Long idExpense) {
        expenseService.deleteExpense(idExpense);
        return true;
    }

    @PutMapping("/")
    @ResponseBody
    public ExpenseDto updateExpenses(@RequestBody ExpenseDto ex) {
        return expenseService.updateExpense(ex);
    }

    @GetMapping("/{idExpense}")
    @ResponseBody
    public ExpenseDto getExpenseById(@PathVariable("idExpense") Long idExpense) {
        return expenseService.getExpenseById(idExpense);
    }

    @GetMapping("/getsumofexpenses/{expenseStartDate}/{expenseEndDate}")
    @ResponseBody
    public float totalSumOfExpensePerMonth(
            @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date expenseStartDate,
            @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date expenseEndDate) {
        return expenseService.totalSumOfExpensePerMonth(expenseStartDate, expenseEndDate);
    }

    @GetMapping("/getremainingcash/{idExpense}")
    @ResponseBody
    public float remainingCash(@PathVariable("idExpense") Long idExpense) {
        return expenseService.remainingCash(idExpense);
    }
}
