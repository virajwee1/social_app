package com.app.signupapi.dto.response;

import com.app.signupapi.domain.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserSignUpResponse {
    private String userId;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private Gender gender;
    private String email;
}
