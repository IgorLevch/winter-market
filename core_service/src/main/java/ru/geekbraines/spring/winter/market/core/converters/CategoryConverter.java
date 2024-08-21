package ru.geekbraines.spring.winter.market.core.converters;

import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import ru.geekbraines.spring.winter.market.api.CategoryDto;
import ru.geekbraines.spring.winter.market.api.ProductDto;
import ru.geekbraines.spring.winter.market.api.ResourceNotFoundException;
import ru.geekbraines.spring.winter.market.core.entities.Category;
import ru.geekbraines.spring.winter.market.core.entities.Product;

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


      public Category dtoToEntity(CategoryDto categoryDto){
       Category c =new Category();
        c.setId(categoryDto.getId());
        c.setTitle(categoryDto.getTitle());
        c.setProducts(categoryDto.getProducts().stream().map(productConverter::dtoToEntity).collect(Collectors.toList()));
      
        return c;
    }

}
