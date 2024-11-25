package com.MockProject.ProductBackend.Data.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "product")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    @Column(name = "product_name", nullable = false)
    private String ProductName;
    @Column(name = "monthly_fee", nullable = false)
    private Double MonthlyFee;

}
