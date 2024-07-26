package ru.geekbraines.spring.winter.market.carts.converters;

import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import ru.geekbraines.spring.winter.market.api.CartDto;

import ru.geekbraines.spring.winter.market.carts.model.Cart;
import ru.geekbraines.spring.winter.market.carts.converters.CartItemConverter;

@Component
@RequiredArgsConstructor
public class CartConverter {
    private final CartItemConverter cartItemConverter;

    

        // из настоящей корзины получим КартДто  
        public CartDto entityToDto(Cart cart){

            CartDto cartDto = new CartDto();
           
            cartDto.setTotalPrice(cart.getTotalPrice());
            cartDto.setItems(cart.getItems().stream().map(cartItemConverter::entityToDto).
            collect(Collectors.toList()));

            return cartDto;

        }


}
