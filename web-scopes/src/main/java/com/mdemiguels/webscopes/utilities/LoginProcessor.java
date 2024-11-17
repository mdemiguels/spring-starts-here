package com.mdemiguels.webscopes.utilities;

import com.mdemiguels.webscopes.services.LoggedUserManagementService;
import com.mdemiguels.webscopes.services.LoginCountService;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
public class LoginProcessor {

    private final LoggedUserManagementService loggedUserManagementService;
    private final LoginCountService loginCountService;

    private String username;
    private String password;

    public LoginProcessor(LoggedUserManagementService loggedUserManagementService, LoginCountService loginCountService) {
        this.loggedUserManagementService = loggedUserManagementService;
        this.loginCountService = loginCountService;
    }

    public boolean login() {

        loginCountService.incrementCount();

        if(username.equals("mdemiguels") && password.equals("1234")) {
            loggedUserManagementService.setUsername(this.username);

            return true;
        }else {
            return false;
        }

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
