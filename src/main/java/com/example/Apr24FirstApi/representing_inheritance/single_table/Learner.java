package com.example.Apr24FirstApi.representing_inheritance.single_table;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
@DiscriminatorValue(value = "1")
public class Learner extends User {
    private String college;
    private String company;
}
