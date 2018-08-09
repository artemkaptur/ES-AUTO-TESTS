package com.epam.esauto.entity;

import java.util.Objects;

public class User {

    private String esLogin;
    private String esPassword;
    private String mailLogin;
    private String mailPassword;

    public String getEsLogin() {
        return esLogin;
    }

    public void setEsLogin(String esLogin) {
        this.esLogin = esLogin;
    }

    public String getEsPassword() {
        return esPassword;
    }

    public void setEsPassword(String esPassword) {
        this.esPassword = esPassword;
    }

    public String getMailLogin() {
        return mailLogin;
    }

    public void setMailLogin(String mailLogin) {
        this.mailLogin = mailLogin;
    }

    public String getMailPassword() {
        return mailPassword;
    }

    public void setMailPassword(String mailPassword) {
        this.mailPassword = mailPassword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(esLogin, user.esLogin) &&
                Objects.equals(esPassword, user.esPassword) &&
                Objects.equals(mailLogin, user.mailLogin) &&
                Objects.equals(mailPassword, user.mailPassword);
    }

    @Override
    public int hashCode() {
        return Objects.hash(esLogin, esPassword, mailLogin, mailPassword);
    }

    @Override
    public String toString() {
        return "User{" +
                "esLogin='" + esLogin + '\'' +
                ", esPassword='" + esPassword + '\'' +
                ", mailLogin='" + mailLogin + '\'' +
                ", mailPassword='" + mailPassword + '\'' +
                '}';
    }
}
