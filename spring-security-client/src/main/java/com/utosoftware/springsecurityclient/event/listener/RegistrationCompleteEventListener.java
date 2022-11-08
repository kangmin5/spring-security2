package com.utosoftware.springsecurityclient.event.listener;

import com.utosoftware.springsecurityclient.entity.User;
import com.utosoftware.springsecurityclient.event.RegistrationCompleteEvent;
import com.utosoftware.springsecurityclient.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Slf4j
public class RegistrationCompleteEventListener implements ApplicationListener<RegistrationCompleteEvent> {
    @Autowired
    private UserService userService;

    @Override
    public void onApplicationEvent(RegistrationCompleteEvent event) {
        //Create the Verification Token for the User with Link ( 링크를 가진 사용자용 검증된 토큰 만들기)
        User user = event.getUser();
        String token = UUID.randomUUID().toString();
        userService.saveVerificationTokenForUser(token,user);
        //Send Mail to user
        String url = event.getApplicationUrl()
                + "/verifyRegistration?token="
                + token;

        //sendVerificationEmail()
        log.info("당신의 계정을 확인하기위해 링크를 클릭하세요:{}",url);
    }
}
