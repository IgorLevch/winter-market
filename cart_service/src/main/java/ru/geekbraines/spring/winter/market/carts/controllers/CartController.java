package ru.geekbraines.spring.winter.market.carts.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import ru.geekbraines.spring.winter.market.api.CartDto;
import ru.geekbraines.spring.winter.market.carts.converters.CartConverter;

import ru.geekbraines.spring.winter.market.carts.services.CartService;

@RestController
@RequestMapping("/api/v1/cart")
@RequiredArgsConstructor
@CrossOrigin("*") //т.к. за это теперь отвечает Гейтвей -- комментим  
public class CartController {

    // пока мы в микросервисах не настраиваем безопасность
//@CrossOrigin("http://localhost:3000")  -- это, например, если хотим, чтобы имели доступ к контроллеру только с порта 3000   
//(например, мы знаем, что наш фронт развернут на порту 3000  -  и будем от него запросы обрабатывать)

    private final CartService cartService;
    private final ru.geekbraines.spring.winter.market.carts.converters.CartConverter cartConverter;

    @GetMapping("/add/{id}")
    public void addToCart(@PathVariable Long id){
        cartService.add(id);

    }

    @GetMapping
    public CartDto getCurrentCart(){
        return cartConverter.entityToDto(cartService.getCurrentCart());
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
