package ru.geekbraines.spring.winter.market.exceptions;

public class AppError {

    private int statusCode; // например 400 или 404
    private String message; // сообщение, которое укажет, что пошло не так
    public int getStatusCode() {
        return statusCode;
    }
    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public AppError() {
    }
    public AppError(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }
  

    
    



}
