package ru.geekbraines.spring.winter.market.core.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ru.geekbraines.spring.winter.market.api.CartDto;
import ru.geekbraines.spring.winter.market.api.ResourceNotFoundException;

import ru.geekbraines.spring.winter.market.core.entities.Order;
import ru.geekbraines.spring.winter.market.core.entities.OrderItem;
import ru.geekbraines.spring.winter.market.core.entities.User;
import ru.geekbraines.spring.winter.market.core.repositories.OrderItemRepository;
import ru.geekbraines.spring.winter.market.core.repositories.OrderRepository;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final ProductService productService;

   
    @Transactional
    public void createOrder(User user){

   
    CartDto cartDto = null; // cartServiceIntegration.getCurrentCart(); получаем корзину из Карт МС
    Order order = new Order();
    order.setUser(user);
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
        // cartServiceIntegration.clear();
                               
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
