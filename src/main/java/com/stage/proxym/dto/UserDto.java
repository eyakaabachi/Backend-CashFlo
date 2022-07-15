package com.stage.proxym.dto;

import com.stage.proxym.entities.Gender;
import com.stage.proxym.entities.ERole;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Data
public class UserDto {

    private String firstName;
    private String LastName;
    private String Email;
    private String Passwd;
    private Gender gender;
    private Date BirthDate;
    private Long PhoneNum;
    private String Address;
    private ERole role;
    private String Profession;
    Set<ExpenseDto> expenseDtoSet;

}
