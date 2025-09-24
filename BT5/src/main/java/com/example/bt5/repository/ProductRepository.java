package com.example.bt5.repository;

import com.example.bt5.entity.Product;
import com.example.bt5.utils.ConnectionUtil;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;




@Repository
public class ProductRepository implements IProductRepository {

    @Override
    public List<Product> findAll() {
        List<Product> productList = new ArrayList<>();
        Session session = ConnectionUtil.sessionFactory.openSession();
//        TypedQuery<Student> query = session.createQuery("from Student");
        TypedQuery<Product> query = session.createNativeQuery("select * from product",Product.class);
        productList = query.getResultList();
        session.close();
        return productList;
    }

    @Override
    public Product findById(int id) {
        Session session = ConnectionUtil.sessionFactory.openSession();
        Product product = session.find(Product.class,id);
        session.close();
        return product;
    }

    public boolean add(Product student) {
        Session session = ConnectionUtil.sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        try{
            transaction.begin();
            // cách update
            // studentUpdate= findById(id);
            // studentUpdate.setName(student.getName)
            //...... set các trường khác
            //  session.merge(studentUpdate);

            // xoá
            // studentDelete= findById(id);
            //  session.remove(studentDelete);
            session.persist(student);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            return false;
        }
        return true;
    }
}