package ru.geekbraines.spring.winter.market.entities;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.*;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="categories")
@NoArgsConstructor
public class Category {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="title")
    private String title;

    @OneToMany(mappedBy = "category")
    private List<Product> products;


    @CreationTimestamp   // это хибернейтовская аннотация/ фиксирует время создания
    @Column(name="created_at")
    private LocalDateTime createdAt;

    @UpdateTimestamp      // это хибернейтовская аннотация / хибернейт обновляет объект текущим временем при апдете
    @Column(name="updated_at")
    private LocalDateTime updatedAt;



}
