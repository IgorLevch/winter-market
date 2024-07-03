package ru.geekbraines.spring.winter.market.core.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import ru.geekbraines.spring.winter.market.core.dtos.Cart;
import ru.geekbraines.spring.winter.market.core.services.CartService;

@RestController
@RequestMapping("/api/v1/cart")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    @GetMapping("/add/{id}")
    public void addToCart(@PathVariable Long id){
        cartService.add(id);

    }

    @GetMapping
    public Cart getCurrentCart(){
        return cartService.getCurrentCart();
    }

    @DeleteMapping("/delete")
    public void  delete(){

     cartService.delete();

    }

    @DeleteMapping("/delete/{id}")
    public void deleteProductById(@PathVariable Long id){

        cartService.deleteById(id);

    }

}
