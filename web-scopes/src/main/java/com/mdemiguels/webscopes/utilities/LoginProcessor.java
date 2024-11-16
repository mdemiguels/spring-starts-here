package com.mdemiguels.webscopes.utilities;

import com.mdemiguels.webscopes.model.User;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
public class LoginProcessor {

    public boolean checkUser(User user) {
        return user.getUsername().equals("mdemiguels") && user.getPassword().equals("password");
    }

}
