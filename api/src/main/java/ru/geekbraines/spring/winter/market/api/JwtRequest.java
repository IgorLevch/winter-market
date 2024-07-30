package ru.geekbraines.spring.winter.market.api;


public class JwtRequest {
    // когда нам с фронта придет логин-пароль, он будет приходить в виде такогоо джейсона с 2-мя полями


    private String username;
    private String password;
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
