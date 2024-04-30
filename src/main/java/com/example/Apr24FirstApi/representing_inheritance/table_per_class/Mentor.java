package com.example.Apr24FirstApi.representing_inheritance.table_per_class;

import lombok.Data;

@Data
public class Mentor extends User {
    private String company;
    private double avgRating;
}
