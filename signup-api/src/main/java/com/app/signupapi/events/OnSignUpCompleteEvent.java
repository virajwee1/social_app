package com.app.signupapi.events;

import com.app.signupapi.domain.User;
import org.springframework.context.ApplicationEvent;

public class OnSignUpCompleteEvent extends ApplicationEvent {

    private String applicationUrl;
    private User user;

    public OnSignUpCompleteEvent(User user, String applicationUrl) {
        super(user);
        this.applicationUrl = applicationUrl;
        this.user = user;
    }
}
