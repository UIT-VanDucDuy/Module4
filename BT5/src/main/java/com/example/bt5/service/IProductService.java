package com.example.bt5.service;

import com.example.bt5.entity.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    Product findById(int id);
    boolean add(Product product);
}