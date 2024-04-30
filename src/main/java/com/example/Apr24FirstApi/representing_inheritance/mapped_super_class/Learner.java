package com.example.Apr24FirstApi.representing_inheritance.mapped_super_class;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity(name = "msc_learner")
public class Learner extends User{
    private String college;
    private String company;
}
