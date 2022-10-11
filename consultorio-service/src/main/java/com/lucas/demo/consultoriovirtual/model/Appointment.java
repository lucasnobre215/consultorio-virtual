package com.lucas.demo.consultoriovirtual.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.lucas.demo.consultoriovirtual.model.enums.AppointmentStatus;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "appointments")
public class Appointment {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name = "date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name="customer_id")
    private User customer;

    @ManyToOne
    @JoinColumn(name="employee_id")
    private User employee;

    @Column(name="status")
    private AppointmentStatus status;

    public Appointment() {
    }


    public AppointmentStatus getStatus() {
        return status;
    }

    public void setStatus(AppointmentStatus status) {
        this.status = status;
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
