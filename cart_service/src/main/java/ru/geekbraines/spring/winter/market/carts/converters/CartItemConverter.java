package ru.geekbraines.spring.winter.market.carts.converters;

import org.springframework.stereotype.Component;

import ru.geekbraines.spring.winter.market.api.CartItemDto;
import ru.geekbraines.spring.winter.market.carts.model.CartItem;

@Component
public class CartItemConverter {


        // это бин, который позволит получить КартАйтемДто из модели данных 
        //это маппер КартАйтимов
        public CartItemDto entityToDto(CartItem cartItem){

            CartItemDto cartItemDto = new CartItemDto();
            cartItemDto.setPrice(cartItem.getPrice());
            cartItemDto.setPricePerProduct(cartItem.getPricePerProduct());
            cartItemDto.setQuantity(cartItem.getQuantity());
            cartItemDto.setProductTitle(cartItem.getProductTitle());
            cartItemDto.setProductId(cartItem.getProductId());

            return cartItemDto;

        }


}
