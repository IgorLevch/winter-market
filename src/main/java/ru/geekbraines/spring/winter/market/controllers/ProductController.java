package ru.geekbraines.spring.winter.market.controllers;

import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import ru.geekbraines.spring.winter.market.entities.Product;
import ru.geekbraines.spring.winter.market.services.ProductService;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public List<Product> findAllProducts(){

        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Product findProductById(@PathVariable Long id){
        return productService.findById(id).get();

    }

    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable Long id){
        productService.deleteById(id);   

    }


}
