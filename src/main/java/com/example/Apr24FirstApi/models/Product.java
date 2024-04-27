package com.example.Apr24FirstApi.models;


import lombok.Data;

@Data
public class Product {
    private long id;
    private String title;
    private double price;
    private String description;
    private String image;
    private Category category;
}
