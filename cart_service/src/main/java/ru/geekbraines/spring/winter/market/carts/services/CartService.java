package ru.geekbraines.spring.winter.market.carts.services;



import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import ru.geekbraines.spring.winter.market.api.ProductDto;
import ru.geekbraines.spring.winter.market.api.ResourceNotFoundException;
import ru.geekbraines.spring.winter.market.carts.integrations.ProductServiceIntegration;
import ru.geekbraines.spring.winter.market.carts.model.Cart;



@Service
@RequiredArgsConstructor
public class CartService {

    private final ProductServiceIntegration productServiceIntegration;
    private Cart tempCart; //   корзина пока что у нас одна 

    @PostConstruct   // инициализируем поля бинов 
    public void init(){
        tempCart = new Cart();
    }


    public Cart getCurrentCart(){

        return tempCart;
    } // этот метод в будущем модифицируем и распишем в будущем, какую кому корзину будем выдавать 

    public void add(Long productId){
     ProductDto product = productServiceIntegration.getProductById(productId);
        tempCart.add(product);

    }

    public void delete(){
        tempCart.deleteAll();
}

   public void deleteById(Long id){

       tempCart.deleteById(id);
}

}
