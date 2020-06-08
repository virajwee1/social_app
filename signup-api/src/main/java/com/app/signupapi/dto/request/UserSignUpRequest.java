package com.app.signupapi.dto.request;

import com.app.signupapi.domain.Gender;
import com.app.signupapi.utils.PasswordMatches;
import com.app.signupapi.utils.ValidEmail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Valid
@PasswordMatches
public class UserSignUpRequest {

    @NotNull(message = "First Name is required")
    private String firstName;

    private String lastName;

    private Date dateOfBirth;

    private Gender gender;

    @ValidEmail
    @NotNull(message = "Email Address is required")
    private String email;

    @NotNull(message = "Password is required")
    private String password;

    @NotNull(message = "Confirm Password is required")
    private String confirmPassword;

}
