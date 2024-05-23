package ru.geekbraines.spring.winter.market.controllers;

import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import ru.geekbraines.spring.winter.market.dtos.ProductDto;
import ru.geekbraines.spring.winter.market.entities.Product;
import ru.geekbraines.spring.winter.market.exceptions.AppError;
import ru.geekbraines.spring.winter.market.exceptions.ResourceNotFoundException;
import ru.geekbraines.spring.winter.market.services.ProductService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public List<ProductDto> findAllProducts(){

        return productService.findAll().stream().map(p -> new ProductDto(p.getId(), p.getTitle(),p.getPrice()))
        .collect(Collectors.toList());
    }


    // // вариант ниже с ResponseEntity комментируем т.к. он достаточно громоздкий:
    // @GetMapping("/{id}")
    // public ResponseEntity<?> findProductById(@PathVariable Long id){

    //     Optional<Product> product = productService.findById(id);
    //     if (!product.isPresent()) {
    //         ResponseEntity<AppError>   err = new ResponseEntity<>(new AppError(HttpStatus.NOT_FOUND.value(),
    //         " product not found, id: " +id), HttpStatus.NOT_FOUND); 
    //         //ResponseEntity - это полное описание нашего ответа
    //         // этот класс применяется, когда хотим в ответ зашить какие-то хитрые Хедеры или объект. 
    //         // когда хотим указать какой-то статус-код 
    //         // в нашем случае в тело ответа будет зашит ДЖейсон и сообщение, почему мы решили ругнуться на такой запрос:
    //         //  (HttpStatus.NOT_FOUND.value(), " product not found, id: " +id)
    //         // а это второй аргумент :  HttpStatus.NOT_FOUND        он укажет, с каким статус-кодом мы вернем ответ 
    //         // (вернем с 404 статусом)
            
    //         return err;

        
    //     } // если продукта нет, то статус код -- 404 
    //     return new ResponseEntity<>(product.get(),HttpStatus.OK);

    // }


    @GetMapping("/{id}")
    public ProductDto findProductById(@PathVariable Long id){

        Product p = productService.findById(id).orElseThrow(()-> 
        new ResourceNotFoundException("product not found, id: " +id));
        return new ProductDto(p.getId(),p.getTitle(),p.getPrice());
        

    }

    // перенесли в отдельный класс :
    
    // @ExceptionHandler //эта аннотация для того, чтобы заставить этот метод перехватывать исключения, появляющиеся в методе 
    // //  public Product findProductById(@PathVariable Long id) (или других методах)
    // // в ресте можно создавать методы, которые перехватывают исключения:
    // public ResponseEntity<AppError> exceptionHandler(ResourceNotFoundException e){ 
    //     // перехватываем ResourceNotFoundException с помощью данного метода 
    //     log.error(e.getMessage(), e);

    //     return new ResponseEntity<>(new AppError(HttpStatus.NOT_FOUND.value(), e.getMessage()), HttpStatus.NOT_FOUND);
    // }    // HttpStatus.NOT_FOUND.value()  - это 404 код , потому что ResourceNotFoundException - однозначно дает, 
    // // что данные не найдены. 
    
    // // КАК ЭТО РАБОТАЕТ: Если в любом методе Контроллера вылетит исключение: ResourceNotFoundException e, 
    // // мы его перехватим,обернем в AppError(HttpStatus.NOT_FOUND.value(), e.getMessage()), HttpStatus.NOT_FOUND);
    // // и вернем клиенту   






    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable Long id){
        productService.deleteById(id);   

    }


}
