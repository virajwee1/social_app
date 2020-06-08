package com.app.signupapi.controller;

import com.app.signupapi.dto.request.UserSignUpRequest;
import com.app.signupapi.dto.response.UserSignUpResponse;
import com.app.signupapi.service.UserSignUpService;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/user")
public class UserSingUpController {

    private final UserSignUpService userSignUpService;
    private final ApplicationEventPublisher applicationEventPublisher;

    public UserSingUpController(UserSignUpService userSignUpService, ApplicationEventPublisher applicationEventPublisher) {
        this.userSignUpService = userSignUpService;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @PostMapping
    public ResponseEntity<UserSignUpResponse> signUpUser(@RequestBody UserSignUpRequest userSignUpRequest){
        userSignUpService.signUpUser(userSignUpRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


}
