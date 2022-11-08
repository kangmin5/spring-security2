package com.utosoftware.springsecurityclient.event;

import com.utosoftware.springsecurityclient.entity.User;

public class RegistrationCompleteEventBuilder11 {
    private User user;
    private String applicationUrl;

    public RegistrationCompleteEventBuilder11 setUser(User user) {
        this.user = user;
        return this;
    }

    public RegistrationCompleteEventBuilder11 setApplicationUrl(String applicationUrl) {
        this.applicationUrl = applicationUrl;
        return this;
    }

    public RegistrationCompleteEvent createRegistrationCompleteEvent() {
        return new RegistrationCompleteEvent(user, applicationUrl);
    }
}