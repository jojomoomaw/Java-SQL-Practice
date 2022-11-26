package io.github.jojomoomaw.JavaSQLPractice.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "product")
public class Product{

    @Id
    @GeneratedValue
    private Integer id;

    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @NotNull
    @Column(name = "active")
    public boolean active;

    public Product(){}
    public Product(String name, Brand brand, boolean active) {
        this.name = name;
        this.brand = brand;
        this.active = active;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", brand=" + brand + "]";    }
}

