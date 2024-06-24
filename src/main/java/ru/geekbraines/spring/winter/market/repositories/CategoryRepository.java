package ru.geekbraines.spring.winter.market.repositories;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ru.geekbraines.spring.winter.market.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    Optional<Category>  findByTitle(String title);

}
