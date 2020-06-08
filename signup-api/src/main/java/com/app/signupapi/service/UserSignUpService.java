package com.app.signupapi.service;

import com.app.signupapi.dto.request.UserSignUpRequest;
import com.app.signupapi.dto.response.UserSignUpResponse;

public interface UserSignUpService {

    UserSignUpResponse signUpUser(UserSignUpRequest userSignUpRequest);

}
