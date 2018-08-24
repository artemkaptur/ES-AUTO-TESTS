package com.epam.esauto.util;

import com.epam.esauto.entity.User;

public class DataHolder {

    private static User registrationPositiveTestUser = new User();

    public static User getRegistrationPositiveTestUser() {
        return registrationPositiveTestUser;
    }

    public void setRegistrationPositiveTestUser(User registrationPositiveTestUser) {
        this.registrationPositiveTestUser = registrationPositiveTestUser;
    }
}
