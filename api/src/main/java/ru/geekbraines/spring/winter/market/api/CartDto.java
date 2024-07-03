package ru.geekbraines.spring.winter.market.api;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;






public class CartDto {

    private List<CartItemDto> items;
    private int totalPrice; // общая стоимость корзины
    
    
    public List<CartItemDto> getItems() {
        return items;
    }
    public void setItems(List<CartItemDto> items) {
        this.items = items;
    }
    public int getTotalPrice() {
        return totalPrice;
    }
    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    // это мы делаем запрет того, чтобы кто-то снаружи мог получить данный список и как-то подменить его:
    // и это метод поиска айтимов: 
   
    
}
