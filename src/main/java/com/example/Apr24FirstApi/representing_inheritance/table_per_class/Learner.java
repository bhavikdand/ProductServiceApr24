package com.example.Apr24FirstApi.representing_inheritance.table_per_class;

import lombok.Data;

@Data
public class Learner extends User {
    private String college;
    private String company;
}
