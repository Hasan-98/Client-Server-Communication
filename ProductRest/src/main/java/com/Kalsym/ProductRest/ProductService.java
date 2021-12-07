/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Kalsym.ProductRest;

import java.io.Serial;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author hasan
 */
@Service
public class ProductService {
    
    @Autowired
    private ProductRepository repo;
    
    public List<Product> listAll() {
        return repo.findAll();
    }
    
    public void save(Product product) {
        repo.save(product);
    }
    
    public Product get(int id) {
        return repo.findById(id).get();
    }

    public void delete(int id) {
        repo.deleteById(id);
    }
}
