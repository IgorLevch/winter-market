package ru.geekbraines.spring.winter.market.api;


public class JwtResponse {
    // в ответ фронту отдаем джейсон: token


    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public JwtResponse() {
    }

    public JwtResponse(String token) {
        this.token = token;
    }
    
    
}
