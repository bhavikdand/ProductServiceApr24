package com.example.Apr24FirstApi.models;


import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private double price;
    private String description;
    private String image;
    @ManyToOne
    private Category category;
}
