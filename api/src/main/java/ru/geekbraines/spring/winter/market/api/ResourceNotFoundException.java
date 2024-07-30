package ru.geekbraines.spring.winter.market.api;

public class ResourceNotFoundException extends RuntimeException {
// этот класс можно создать для ненайденных объектов. 

    public ResourceNotFoundException(String message) {
        super(message);
    }

}
