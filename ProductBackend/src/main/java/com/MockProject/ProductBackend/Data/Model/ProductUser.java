package com.MockProject.ProductBackend.Data.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jakarta.persistence.Table;

@Table(name = "product_user")
@Entity
public class ProductUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(name = "user_id", nullable = false)
    private Integer UID;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public ProductUser() {
    }

    public ProductUser(Integer UID, Product product) {
        this.UID = UID;
        this.product = product;
    }

    public ProductUser(Long Id, Integer UID, Product product) {
        this.Id = Id;
        this.UID = UID;
        this.product = product;
    }

    public void setId(Long id) {
        Id = id;
    }

    public void setUID(Integer UID) {
        this.UID = UID;
    }

    public void setSelectedproduct(Product product) {
        this.product = product;
    }

    public Long getId() {
        return Id;
    }

    public Product getSelectedproduct() {
        return product;
    }

    public Integer getUID() {
        return UID;
    }
}
