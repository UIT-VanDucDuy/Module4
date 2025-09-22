package com.example.bt5.repository;

import com.example.bt5.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;




@Repository
public class ProductRepository implements IProductRepository {

    private static List<Product> productList = new ArrayList<>();
    static {
//        studentList.add(new Student(1,"chánh1",true, Arrays.asList("java","js","php"),"C02"));
//        studentList.add(new Student(2,"chánh1",true, Arrays.asList("java","js","php"),"C02"));
//        studentList.add(new Student(3,"chánh1",true, Arrays.asList("java","js","php"),"C02"));
    }

    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public Product findById(int id) {
        for (Product product : productList){
            if (id== product.getId()){
                return product;
            }
        }
        return null;
    }

    @Override
    public boolean add(Product product) {
        return productList.add(product);
    }
}