package ru.geekbraines.spring.winter.market.dtos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lombok.Data;
import ru.geekbraines.spring.winter.market.entities.Product;

@Data
public class Cart {

    private List<CartItem> items;
    private int totalPrice; // общая стоимость корзины

    // это мы делаем запрет того, чтобы кто-то снаружи мог получить данный список и как-то подменить его:
    // и это метод поиска айтимов: 
    public List<CartItem>  getItems(){
        return Collections.unmodifiableList(items);
    }


    

public Cart() {
   this.items = new ArrayList<CartItem>();

}




// добавление продуктов в корзину: 
   public void add(Product product){ // TODO доработать в ДЗ
        items.add(new CartItem(product.getId(), product.getTitle(), 1, product.getPrice(), product.getPrice()));
        recalculate();
   }



    // приватный метод пересчета стоимости: 
    private void recalculate(){

        totalPrice = 0;
        for (CartItem cartItem : items) {
            totalPrice += cartItem.getPrice();
        }
    }

    public void deleteAll(){
        items.clear();
    }

    public void deleteById(Long id){

        items.remove(id);
    }


}
