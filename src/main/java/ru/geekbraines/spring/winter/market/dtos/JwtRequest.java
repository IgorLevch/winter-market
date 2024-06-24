package ru.geekbraines.spring.winter.market.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JwtRequest {
    // когда нам с фронта придет логин-пароль, он будет приходить в виде такогоо джейсона с 2-мя полями


    private String username;
    private String password;


}
