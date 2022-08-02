package com.stage.proxym.income.api;

import com.stage.proxym.dto.IncomeDto;
import com.stage.proxym.income.service.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("income")
public class IncomeController {
    @Autowired
    IncomeService incomeService;

    @PostMapping("/")
    public IncomeDto addIncome(@RequestBody IncomeDto i) {
        return incomeService.addIncome(i);
    }
    @DeleteMapping("/{idIncome}")
    @ResponseBody
    public boolean deleteIncome(@PathVariable("idIncome") Long idIncome) {
        incomeService.deleteIncome(idIncome);
        return true;
    }

    @PutMapping("/")
    @ResponseBody
    public IncomeDto updateIncome(@RequestBody IncomeDto i) {
        return incomeService.updateIncome(i);
    }
    @GetMapping("/{idIncome}")
    @ResponseBody
    public IncomeDto getIncomeById(@PathVariable("idIncome") Long idIncome) {
        return incomeService.getIncomeById(idIncome);
    }
    @GetMapping("/getsumofincomes/{IncomeStartDate}/{IncomeEndDate}")
    @ResponseBody
    public double totalSumOfIncomePerMonth(
            @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date IncomeStartDate,
            @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd")  Date IncomeEndDate){
        return incomeService.totalSumOfIncomePerMonth(IncomeStartDate,IncomeEndDate);
    }
    @GetMapping("/gethighestincome/{IncomeStartDate}/{IncomeEndDate}")
    @ResponseBody
    public String findHighestIncome(
                                  @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date IncomeStartDate,
                                  @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd")  Date IncomeEndDate) {
        return incomeService.findHighestIncome(IncomeStartDate,IncomeEndDate);
    }
}
