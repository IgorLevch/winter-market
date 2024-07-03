package ru.geekbraines.spring.winter.market.core.services;


import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import ru.geekbraines.spring.winter.market.core.entities.Category;
import ru.geekbraines.spring.winter.market.core.repositories.CategoryRepository;

@Service
@RequiredArgsConstructor
public class CategoryService {

     private final CategoryRepository categoryRepository;

    public Optional<Category> findByTitle(String title){

        return categoryRepository.findByTitle(title);
    }


}
