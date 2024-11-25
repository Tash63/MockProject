package com.MockProject.ProductBackend.Data.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "product_user")
@Entity
@EqualsAndHashCode
public class ProductUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(name = "user_id", nullable = false)
    private Integer UID;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
