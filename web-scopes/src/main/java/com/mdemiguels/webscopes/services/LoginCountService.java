package com.mdemiguels.webscopes.services;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

@Service
@ApplicationScope
public class LoginCountService {
    private int count;

    public void incrementCount() {
        count++;
    }

    public int getCount() {
        return count;
    }

}
