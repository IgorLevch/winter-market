package ru.geekbraines.spring.winter.market.dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {

      private Long id;
    private String title;
    private List<ProductDto> products;

}
