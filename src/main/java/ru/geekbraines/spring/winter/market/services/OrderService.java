package ru.geekbraines.spring.winter.market.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ru.geekbraines.spring.winter.market.dtos.Cart;
import ru.geekbraines.spring.winter.market.entities.Order;
import ru.geekbraines.spring.winter.market.entities.OrderItem;
import ru.geekbraines.spring.winter.market.entities.User;
import ru.geekbraines.spring.winter.market.exceptions.ResourceNotFoundException;
import ru.geekbraines.spring.winter.market.repositories.OrderItemRepository;
import ru.geekbraines.spring.winter.market.repositories.OrderRepository;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final ProductService productService;
    private final CartService cartService;
    @Transactional
    public void createOrder(User user){

    Cart cart = cartService.getCurrentCart();
    Order order = new Order();
    order.setUser(user);
    order.setTotalPrice(cart.getTotalPrice());
    orderRepository.save(order);
        
    
    List<OrderItem> orderItems = cart.getItems().stream()
                .map(cartItem -> {
                    OrderItem orderItem = new OrderItem();
                    orderItem.setProduct(productService.findById(cartItem.getProductId()).orElseThrow(
                            ()->new ResourceNotFoundException("Can't add a product with id: "+ cartItem.getProductId())
                    ));
                    orderItem.setOrder(order);
                    orderItem.setPrice(cartItem.getPrice());
                    orderItem.setPricePerProduct(cartItem.getPricePerProduct());
                    orderItem.setQuantity(cartItem.getQuantity());
                    orderItemRepository.save(orderItem);
                    return orderItem;
                }).collect(Collectors.toList());


   // cart.clear();

    }

}
