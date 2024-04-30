package com.example.Apr24FirstApi.representing_inheritance.joined_table;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Data;

@Data
@Entity(name="jt_mentors")
@PrimaryKeyJoinColumn(name= "user_id")
public class Mentor extends User {
    private String company;
    private double avgRating;
}
