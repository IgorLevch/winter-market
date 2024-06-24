package ru.geekbraines.spring.winter.market.services;


import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import ru.geekbraines.spring.winter.market.entities.Category;
import ru.geekbraines.spring.winter.market.repositories.CategoryRepository;

@Service
@RequiredArgsConstructor
public class CategoryService {

     private final CategoryRepository categoryRepository;

    public Optional<Category> findByTitle(String title){

        return categoryRepository.findByTitle(title);
    }


}
