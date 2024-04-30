package com.example.Apr24FirstApi.cardinalities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Husband {
    @Id
    private long id;
    String name;
    @OneToOne(mappedBy = "husband")
    private Wife wife;

}
