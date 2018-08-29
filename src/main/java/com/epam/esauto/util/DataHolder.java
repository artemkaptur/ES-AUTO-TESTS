package com.epam.esauto.util;

import com.epam.esauto.entity.User;

public class DataHolder {

    private static User registrationPositiveTestUser = new User();
    private static String argument;


    public static User getRegistrationPositiveTestUser() {
        return registrationPositiveTestUser;
    }

    public void setRegistrationPositiveTestUser(User registrationPositiveTestUser) {
        this.registrationPositiveTestUser = registrationPositiveTestUser;
    }

    public static String getArgument(){
        return argument;
    }

    public static void setArgument(String arg){
        argument = arg;
    }
}
