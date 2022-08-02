package com.stage.proxym.dto;

import lombok.*;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class IncomeDto {
    private long idIncome;
    private String incomeSource;
    private float incomeMoney;
    private Date incomeStartDate;
    private Date incomeExpireDate;
    private String description;
}
