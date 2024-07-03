package ru.geekbraines.spring.winter.market.core.services;



import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import ru.geekbraines.spring.winter.market.core.dtos.Cart;
import ru.geekbraines.spring.winter.market.core.entities.Product;
import ru.geekbraines.spring.winter.market.core.exceptions.ResourceNotFoundException;

@Service
@RequiredArgsConstructor
public class CartService {

    private final ProductService productService;
    private Cart tempCart; //   корзина пока что у нас одна 

    @PostConstruct   // инициализируем поля бинов 
    public void init(){
        tempCart = new Cart();
    }


    public Cart getCurrentCart(){

        return tempCart;
    } // этот метод в будущем модифицируем и распишем в будущем, какую кому корзину будем выдавать 

    public void add(Long productId){
     Product product = productService.findById(productId).orElseThrow(()-> 
     new ResourceNotFoundException("We can't find product with id = " + productId +"to a Cart. Product not found"));
        tempCart.add(product);

    }

    public void delete(){
        tempCart.deleteAll();
}

   public void deleteById(Long id){

       tempCart.deleteById(id);
}

}
