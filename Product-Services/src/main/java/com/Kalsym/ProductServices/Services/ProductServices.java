/*
 * Copyright (C) 2021 hasan
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.Kalsym.ProductServices.Services;

import com.Kalsym.ProductServices.Model.ProductReview;
import com.Kalsym.ProductServices.Model.ProductVariantAvailable;
import com.Kalsym.ProductServices.Model.ProductVariant;
import com.Kalsym.ProductServices.Repositries.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Kalsym.ProductServices.Model.*;

/**
 *
 * @author hasan
 */
@Service
public class ProductServices {

    @Autowired
    private ProductRepository productRepo;

    @Autowired
    private ProductReviewRepository productReviewRepo;

    @Autowired
    private ProductVariantRepository productVariantRepo;

    @Autowired
    private ProductVariantAvailableRepository productVariantAvailableRepo;

    public ProductServices(ProductRepository productRepo, ProductReviewRepository productReviewRepo, ProductVariantRepository productVariantRepo, ProductVariantAvailableRepository productVariantAvailableRepo) {
        this.productRepo = productRepo;
        this.productReviewRepo = productReviewRepo;
        this.productVariantRepo = productVariantRepo;
        this.productVariantAvailableRepo = productVariantAvailableRepo;
    }

    public void addProduct(Product product) {
        productRepo.save(product);
    }

    public void addProductReview(ProductReview productReview) {
        System.out.println("In Review Service");
        productReviewRepo.save(productReview);
    }

    public void addProductVariant(ProductVariant productVariant) {
        productVariantRepo.save(productVariant);
    }

    public void addProductVariantAvailable(ProductVariantAvailable productVariantAvailable) {
        productVariantAvailableRepo.save(productVariantAvailable);
    }
}
