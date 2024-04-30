package com.example.Apr24FirstApi.representing_inheritance.table_per_class;

import lombok.Data;

@Data
public class TA extends User {
    private double avgRating;
    private String college;
}
