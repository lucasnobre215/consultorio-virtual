package com.lucas.demo.consultoriovirtual.model;


import javax.persistence.*;

@Entity
@Table(name = "proccedures")
public class Procedures {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Double price;
    @ManyToOne
    @JoinColumn(name="company_id")
    private Company company;


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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Procedures() {
    }

    public Procedures(Long id, String name, Double price, Company company) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.company = company;
    }
}

