package ru.geekbraines.spring.winter.market.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import ru.geekbraines.spring.winter.market.entities.Product;
import ru.geekbraines.spring.winter.market.repositories.ProductRepository;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;


    public List<Product>  findAll(){

        return productRepository.findAll();
    }

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    public void deleteById(Long id){
        productRepository.deleteById(id);

    }



}
