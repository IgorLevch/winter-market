package ru.geekbraines.spring.winter.market.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="roles")
//@NoArgsConstructor
public class Role {

    

    public Role() {
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;


    @Column(name="name")
    private String name;


     



}
