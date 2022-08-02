package com.stage.proxym.dto;

import com.stage.proxym.user.entity.Gender;
import com.stage.proxym.user.entity.ERole;
import lombok.*;

import java.util.Date;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDto {
    private long idUser;
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
