package com.example.nxttrendz2.repository;

import com.example.nxttrendz2.model.*;

import java.util.ArrayList;

public interface ProductRepository {
    ArrayList<Product> getProducts();

    Product getProductById(int id);

    Product addProduct(Product product);

    Product updateProduct(int id, Product product);

    void deleteProduct(int id);

    Category getProductCategory(int id);
}
