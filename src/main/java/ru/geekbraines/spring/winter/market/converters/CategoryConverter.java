package ru.geekbraines.spring.winter.market.converters;

import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import ru.geekbraines.spring.winter.market.dtos.CategoryDto;
import ru.geekbraines.spring.winter.market.entities.Category;

@Component
@RequiredArgsConstructor
public class CategoryConverter {

     private final ProductConverter productConverter;
    public CategoryDto entityToDto(Category category){ // категорию к ДТО
        CategoryDto c = new CategoryDto();
        c.setId(category.getId());
        c.setTitle(category.getTitle());
        c.setProducts(category.getProducts().stream().map(productConverter::entityToDto).collect(Collectors.toList()));

        return c;
    }

}
