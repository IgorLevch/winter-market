package ru.geekbraines.spring.winter.market.dtos;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;




@Data
@NoArgsConstructor // джесоновские объекты должны быть всегда с дефолтным конструктором (джексон, когда получает/отдает объект
// в джейсоне, использует дефолтный конструктор для его формирования)
@AllArgsConstructor
public class ProductDto {
    // ДТО - не сущность и не табличная сущность. 



    private Long id;   
    private String title;
    private int price;
    

}
