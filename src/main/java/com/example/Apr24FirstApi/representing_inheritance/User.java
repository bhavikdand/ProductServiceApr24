package com.example.Apr24FirstApi.representing_inheritance;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "dummy_users")
public class User {
    @Id
    private long id;
    private String username;
    private String password;
}
