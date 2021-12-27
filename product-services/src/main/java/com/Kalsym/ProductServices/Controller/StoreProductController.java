package com.Kalsym.ProductServices.Controller;

import com.Kalsym.ProductServices.Model.Product;
import com.Kalsym.ProductServices.Services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author 7cu
 */
@RestController
@RequestMapping("/products")
public class StoreProductController {

    ProductServices productServices;

    @Autowired
    public StoreProductController(ProductServices productServices) {
        this.productServices = productServices;
    }

    @GetMapping("/list")
    public ResponseEntity<Object> getAllProducts() {
        return productServices.findAll();
    }

    @PostMapping("/add")
    public ResponseEntity<Object> saveProduct(@RequestBody Product product) {
        return productServices.save(product);
    }
}
