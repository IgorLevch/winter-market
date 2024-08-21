package ru.geekbraines.spring.winter.market.carts.model;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItem {

    // класс - элемент корзины. Показаывает, что будет представлять из себя 1 строчка корзины. 


    private Long productId;
    private String productTitle;
    private int quantity;
    private BigDecimal pricePerProduct;
    private BigDecimal price;     // общая стоимость 


}
