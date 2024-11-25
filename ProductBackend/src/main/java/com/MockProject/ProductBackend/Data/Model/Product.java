package com.MockProject.ProductBackend.Data.Model;
import jakarta.persistence.*;
@Entity
@Table(name = "product")

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    @Column(name = "product_name", nullable = false)
    private String ProductName;
    @Column(name = "monthly_fee", nullable = false)
    private Double MonthlyFee;

    public Product() {
    }

    public Product(String ProductName, Double MonthlyFee) {
        this.ProductName = ProductName;
        this.MonthlyFee = MonthlyFee;
    }

    public Product(Long Id, String ProductName, Double MonthlyFee) {
        this.Id = Id;
        this.ProductName = ProductName;
        this.MonthlyFee = MonthlyFee;
    }

    public void setId(Long id) {
        Id = id;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public void setMonthlyFee(Double monthlyFee) {
        MonthlyFee = monthlyFee;
    }

    public Long getId() {
        return Id;
    }

    public String getProductName() {
        return ProductName;
    }

    public Double getMonthlyFee() {
        return MonthlyFee;
    }
}
