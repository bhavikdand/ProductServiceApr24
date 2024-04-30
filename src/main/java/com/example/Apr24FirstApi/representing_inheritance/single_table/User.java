package com.example.Apr24FirstApi.representing_inheritance.single_table;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Inheritance
@Entity(name = "st_users")
@DiscriminatorColumn(
        name="user_type",
        discriminatorType = DiscriminatorType.INTEGER
)
@DiscriminatorValue(value = "0")
public class User {
    @Id
    private long id;
    private String name;
    private String email;
    private String password;
}
