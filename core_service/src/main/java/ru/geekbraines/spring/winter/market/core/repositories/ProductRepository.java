package ru.geekbraines.spring.winter.market.core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ru.geekbraines.spring.winter.market.core.entities.Product;



@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
