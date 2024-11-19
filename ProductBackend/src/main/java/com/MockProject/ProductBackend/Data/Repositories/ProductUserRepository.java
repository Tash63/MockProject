package com.MockProject.ProductBackend.Data.Repositories;

import com.MockProject.ProductBackend.Data.Model.Product;
import com.MockProject.ProductBackend.Data.Model.ProductUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductUserRepository extends JpaRepository<ProductUser, Long> {
    @Query("SELECT u FROM ProductUser u WHERE u.UID=?1")
    public List<ProductUser> findProductByUserId(Long UserId);
}
