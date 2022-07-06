package com.stage.proxym.dto;

import lombok.Data;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Data
public class incomeDto {
    private String incomeSource;
    private float incomeMoney;
    private Date incomeStartDate;
    private Date incomeExpireDate;
    private String description;
}
