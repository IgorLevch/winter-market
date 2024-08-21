package ru.geekbraines.spring.winter.market.core.services;


import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ru.geekbraines.spring.winter.market.api.CartDto;


import ru.geekbraines.spring.winter.market.core.entities.Order;
import ru.geekbraines.spring.winter.market.core.entities.OrderItem;
import ru.geekbraines.spring.winter.market.core.integrations.CartServiceIntegration;

import ru.geekbraines.spring.winter.market.core.repositories.OrderRepository;
import ru.geekbraines.spring.winter.market.core.services.ProductService;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {

    private final OrderRepository orderRepository;
    private final ProductService productService;
    private final CartServiceIntegration cartServiceIntegration;

   
    @Transactional
    public Order createOrder(String username){

   
    CartDto cartDto = cartServiceIntegration.getCurrentCart();// получаем корзину из Карт МС
    Order order = new Order();
    order.setUsername(username);
    order.setTotalPrice(cartDto.getTotalPrice()); 
    order.setItems(cartDto.getItems().stream().map(
        cartItem -> new OrderItem(
            productService.findById(cartItem.getProductId()).get(),
            order,
            cartItem.getQuantity(),
            cartItem.getPricePerProduct(),
            cartItem.getPrice()
        ) 

    ).collect(Collectors.toList()));   // элементы корзины пребразовали к элементам заказа   



    orderRepository.save(order);
         cartServiceIntegration.clear();
         return order;
                               
    // List<OrderItem> orderItems = cart.getItems().stream()
    //             .map(cartItem -> {
    //                 OrderItem orderItem = new OrderItem();
    //                 orderItem.setProduct(productService.findById(cartItem.getProductId()).orElseThrow(
    //                         ()->new ResourceNotFoundException("Can't add a product with id: "+ cartItem.getProductId())
    //                 ));
    //                 orderItem.setOrder(order);
    //                 orderItem.setPrice(cartItem.getPrice());
    //                 orderItem.setPricePerProduct(cartItem.getPricePerProduct());
    //                 orderItem.setQuantity(cartItem.getQuantity());
    //                 orderItemRepository.save(orderItem);
    //                 return orderItem;
    //             }).collect(Collectors.toList());


   // cart.clear();

    }

}
