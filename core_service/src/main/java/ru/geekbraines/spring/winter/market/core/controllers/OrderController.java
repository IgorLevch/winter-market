package ru.geekbraines.spring.winter.market.core.controllers;

import org.springframework.boot.actuate.web.exchanges.HttpExchange.Principal;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import ru.geekbraines.spring.winter.market.core.entities.User;
import ru.geekbraines.spring.winter.market.core.services.OrderService;
import ru.geekbraines.spring.winter.market.core.services.UserService;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {
    private final UserService userService;
    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createOrder(Principal principal){
    User user = userService.findByUsername(principal.getName()).orElseThrow(()->new RuntimeException("User not found"));
      orderService.createOrder(user);

    }

}
