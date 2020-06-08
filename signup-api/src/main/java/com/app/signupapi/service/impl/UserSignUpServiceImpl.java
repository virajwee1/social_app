package com.app.signupapi.service.impl;

import com.app.signupapi.domain.User;
import com.app.signupapi.dto.request.UserSignUpRequest;
import com.app.signupapi.dto.response.UserSignUpResponse;
import com.app.signupapi.exceptions.UserAlreadyExistsException;
import com.app.signupapi.repository.UserRepository;
import com.app.signupapi.service.UserSignUpService;
import org.springframework.stereotype.Service;

@Service
public class UserSignUpServiceImpl implements UserSignUpService {

    private final UserRepository userRepository;

    public UserSignUpServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserSignUpResponse signUpUser(UserSignUpRequest userSignUpRequest) {

        boolean userAlreadyExists = userRepository.existsByEmail(userSignUpRequest.getEmail());

        if (userAlreadyExists) {
            throw new UserAlreadyExistsException(userSignUpRequest.getEmail());
        }
        User user = this.covertUserSignUpRequestToUser(userSignUpRequest);
        return this.convertUserToUserSignUpResponse(userRepository.save(user));
    }


    public User covertUserSignUpRequestToUser(UserSignUpRequest userSignUpRequest) {
        User user = new User();
        user.setFirstName(userSignUpRequest.getFirstName());
        user.setLastName(userSignUpRequest.getLastName());
        user.setDateOfBirth(userSignUpRequest.getDateOfBirth());
        user.setGender(userSignUpRequest.getGender());
        user.setEmail(userSignUpRequest.getEmail());
        user.setPassword(userSignUpRequest.getPassword());
        //Setting up user as inactive initially
        user.setActive(Boolean.FALSE);
        return user;
    }

    public UserSignUpResponse convertUserToUserSignUpResponse(User user) {
        UserSignUpResponse userSignUpResponse = new UserSignUpResponse();
        userSignUpResponse.setFirstName(user.getFirstName());
        userSignUpResponse.setLastName(user.getLastName());
        userSignUpResponse.setDateOfBirth(user.getDateOfBirth());
        userSignUpResponse.setEmail(user.getEmail());
        return userSignUpResponse;
    }
}
