package com.example.nxttrendz2.repository;

import com.example.nxttrendz2.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductJpaRepository extends JpaRepository<Product, Integer> {
}
