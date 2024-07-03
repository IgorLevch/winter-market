package ru.geekbraines.spring.winter.market.carts.integrations;

import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.condition.ProducesRequestCondition;

import lombok.RequiredArgsConstructor;
import ru.geekbraines.spring.winter.market.api.ProductDto;

@Component
@RequiredArgsConstructor
public class ProductServiceIntegration {
    // Cart microservice спокойно работает с core microservice через данный слой

    private final RestTemplate restTemplate;

    public Optional<ProductDto> getProductById(Long id){

        // отправляем гет-запрос на получение объекта
        // указываем адрес(того, куда мы пошлем наш запрос) и класс ответа, который ожидаем получить. 

            return Optional.ofNullable(restTemplate.getForObject(
                "http://localhost:8189/winter/api/v1/products/"+id,
            ProductDto.class));
    }
}
