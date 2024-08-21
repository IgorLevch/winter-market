// package ru.geekbraines.spring.winter.market.core.repositories;

// import org.springframework.data.jpa.domain.Specification;

// import ru.geekbraines.spring.winter.market.core.entities.Product;

// public class ProductSpecification {

//     public static Specification<Product> titleContains(String word){
//             if (word == null) {
//                 return Specification.of(null);
//             }
//             return (root, criteriaQuery, criteriaBuilder) -> {
//                 return criteriaBuilder.like(root.get("title"), "%" + word + "%");
//             };
//     }

//     public static Specification<Product> priceGreaterThanOrEq(double value){
//             return (Specification<Product>) (root, criteriaQuery, criteriaBuilder) -> {
//                 return criteriaBuilder.greaterThanOrEqualTo(root.get("price"), value);
//             };

//     }

//     public static Specification<Product> priceLesserThanOrEq(double value){
//         return (Specification<Product>) (root, criteriaQuery, criteriaBuilder) -> {
//             return criteriaBuilder.lessThanOrEqualTo(root.get("price"), value); 
//     };



// }
// }
