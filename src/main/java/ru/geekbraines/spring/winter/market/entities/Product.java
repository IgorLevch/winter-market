package ru.geekbraines.spring.winter.market.entities;

import org.springframework.data.annotation.Id;

// import jakarta.persistence.*;
// import jakarta.persistence.Table;

import javax.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="products")
@NoArgsConstructor
public class Product {


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="title")
    private String title;

    @Column(name="price")
    private int price;




}
