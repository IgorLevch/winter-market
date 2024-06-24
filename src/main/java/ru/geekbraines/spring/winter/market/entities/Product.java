package ru.geekbraines.spring.winter.market.entities;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


import jakarta.persistence.*;
import lombok.Data;


import java.time.LocalDateTime;



@Data
@Entity
@Table(name="products")
//@NoArgsConstructor
public class Product {
    

    public Product() {
    }
    

    public Product(Long id, String title, int price) {
        this.id = id;
        this.title = title;
        this.price = price;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="title")
    private String title;

    @Column(name="price")
    private int price;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;


    @CreationTimestamp    // это хибернейтовская аннотация/ фиксирует время создания
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @UpdateTimestamp    // это хибернейтовская аннотация / хибернейт обновляет объект текущим временем при апдете
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

   

    

}
