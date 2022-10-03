package com.lucas.demo.consultoriovirtual.model;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="company")
public class Company {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
