package com.MockProject.ProductBackend.Data.Repositories;

import com.MockProject.ProductBackend.Data.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
