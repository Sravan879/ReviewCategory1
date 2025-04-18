package com.example.nxttrendz2.repository;

import com.example.nxttrendz2.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryJpaRepository extends JpaRepository<Category, Integer> {
}
