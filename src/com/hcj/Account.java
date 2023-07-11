package com.hcj;

/**
 * Account
 *
 * @author hcj
 * @date 2023-07-11
 */
public class Account {
    /**
     * 存储用户名
    */
    private String username;
    /**
     * 存储密码
     */
    private String password;

    public Account() {
    }

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
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

    @Override
    public String toString() {
        return "Account{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
