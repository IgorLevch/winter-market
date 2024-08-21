package ru.geekbraines.spring.winter.market.core.services;


import java.util.List;
import java.util.Optional;


import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import ru.geekbraines.spring.winter.market.api.ProductDto;
import ru.geekbraines.spring.winter.market.api.ResourceNotFoundException;
import ru.geekbraines.spring.winter.market.core.entities.Category;
import ru.geekbraines.spring.winter.market.core.entities.Product;
import ru.geekbraines.spring.winter.market.core.repositories.ProductRepository;
import ru.geekbraines.spring.winter.market.core.services.CategoryService;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryService categoryService;


    public List<Product>  findAll(){

        return productRepository.findAll();
    }

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    public void deleteById(Long id){
        productRepository.deleteById(id);

    }


    public Product createNewProduct(ProductDto productDto){
        Product product = new Product();
        product.setPrice(productDto.getPrice());
        product.setTitle(product.getTitle());

        Category category = categoryService.findByTitle(productDto.getCategoryTitle()).orElseThrow(() ->
                new ResourceNotFoundException("Category not found"));
        product.setCategory(category);
        productRepository.save(product);

        return product;
    }

    // public List<Product> getProductsWithPagingAndFiltering(Filters filters){

    //     Specification<Product> spec = Specification.where(null);
    //     StringBuilder f = new StringBuilder();
    //     if (filters.getWord() != null) {
    //         spec = spec.and(ProductSpecs.titleContains(filters.getWord()));
    //     }
    //     if (filters.getMin() != null) {
    //         spec = spec.and(ProductSpecs.priceGreaterThanOrEq(filters.getMin()));
    //     }
    //     if (filters.getMax() != null) {
    //         spec = spec.and(ProductSpecs.priceLesserThanOrEq(filters.getMax()));
    //     }
    //     return productRepository.findAll(spec);
            
    //     }

        // public List<Product> findByFilter(FilterData filterData){
            
        //     BigDecimal minPrice = filterData.getMinPrice();
        //     BigDecimal maxPrice = filterData.getMaxPrice();
        //     String textForSearch = filterData.getTextSearch();

        //     if (minPrice==null) minPrice =BigDecimal.ZERO;
        //     if (maxPrice==null) maxPrice =BigDecimal.ZERO;
        //     if(textForSearch == null) textForSearch = "~*";
        //     if (maxPrice.equals(BigDecimal.ZERO)) 
        //         return productRepository.findAllByPriceGreaterThanEqualAndTitleContaines(minPrice, textForSearch);

        //         return productRepository.
        //         findAllByPriceGreaterThanEqualAndPriceLessThanEqualAndTitleContaines(minPrice, maxPrice, textForSearch);
                
        //     }

            

        }
            
            







