package com.lucas.demo.consultoriovirtual.model;


import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "appointments")
public class Appointment {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name = "date")
    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name="customer_id")
    private User customer;

    @ManyToOne
    @JoinColumn(name="employee_id")
    private User employee;


    public Appointment() {
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }

    public User getEmployee() {
        return employee;
    }

    public void setEmployee(User employee) {
        this.employee = employee;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Appointment(Long id, LocalDateTime date, User customer, User employee, Company company) {
        this.id = id;
        this.date = date;
        this.customer = customer;
        this.employee = employee;
        this.company = company;
    }

    @ManyToOne
    @JoinColumn(name="company_id")
    private Company company;
}
