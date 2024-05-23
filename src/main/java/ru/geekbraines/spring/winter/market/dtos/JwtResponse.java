package ru.geekbraines.spring.winter.market.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JwtResponse {
    // в ответ фронту отдаем джейсон: token


    private String token;
    
}
