package com.sabel.sqlite.login;

public class Login {

    private String loginName;
    private String password;


    public Login(String loginName, String password) {
        this.loginName = loginName;
        this.password = password;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Login login = (Login) o;

        if (loginName != null ? !loginName.equals(login.loginName) : login.loginName != null) return false;
        return password != null ? password.equals(login.password) : login.password == null;
    }

    @Override
    public int hashCode() {
        int result = loginName != null ? loginName.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return  loginName + password;
    }
}
