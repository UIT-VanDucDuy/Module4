package com.example.bt5.repository;


import com.example.bt5.entity.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();
    Product findById(int id);
    boolean add(Product product);

}