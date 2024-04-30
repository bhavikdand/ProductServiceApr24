package com.example.Apr24FirstApi.cardinalities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class Wife {
    @Id
    private long id;
    private String name;
    @OneToOne
    private Husband husband;

}
