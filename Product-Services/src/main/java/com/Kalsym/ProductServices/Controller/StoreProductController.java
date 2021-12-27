package com.Kalsym.ProductServices.Controller;

import com.Kalsym.ProductServices.Model.ProductReview;
import com.Kalsym.ProductServices.Model.ProductVariantAvailable;
import com.Kalsym.ProductServices.Model.ProductVariant;
import com.Kalsym.ProductServices.Repositries.ProductRepository;
import com.Kalsym.ProductServices.Repositries.ProductVariantAvailableRepository;
import com.Kalsym.ProductServices.Repositries.ProductVariantRepository;
import com.Kalsym.ProductServices.Services.ProductServices;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.MalformedURLException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Value;

import com.Kalsym.ProductServices.Model.*;

/**
 * @author 7cu
 */
@RestController()
@RequestMapping("/products")
public class StoreProductController {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductVariantRepository productVariantRepository;

    @Autowired
    ProductVariantAvailableRepository productVariantAvailableRepository;

    @Autowired
    private ProductServices service;

    @PostMapping(value = "/addProduct")
    public ResponseEntity<Object> saveProduct(Product product, ProductReview productReview, ProductVariant productVariant, ProductVariantAvailable productVariantAvailable) {
        System.out.println("In Save Product");
        service.addProduct(product);
        service.addProductReview(productReview);
       // service.addProductReview(productReview);
        service.addProductVariant(productVariant);
        service.addProductVariantAvailable(productVariantAvailable);
        return new ResponseEntity<>("Product Added", HttpStatus.OK);

    }
// test functions 

    @PostMapping(value = "/addProductVariant")
    public ResponseEntity<Object> saveProduct(ProductVariant productVariant) {
        System.out.println("In Save Product");
        service.addProductVariant(productVariant);
        return new ResponseEntity<>("Product Added", HttpStatus.OK);

    }

    @PostMapping(value = "/addOnlyProduct")
    public ResponseEntity<Object> saveProduct(Product product) {
        System.out.println("In Save Product");
        service.addProduct(product);
        return new ResponseEntity<>("Product Added", HttpStatus.OK);

    }

    @PostMapping(value = "/addProductReview")
    public ResponseEntity<Object> saveProduct(ProductReview productReview) {
        System.out.println("In Save Product Review");
        service.addProductReview(productReview);
        return new ResponseEntity<>("Product Added", HttpStatus.OK);

    }

}
