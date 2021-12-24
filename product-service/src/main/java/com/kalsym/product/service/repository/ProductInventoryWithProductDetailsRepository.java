package com.kalsym.product.service.repository;

import com.kalsym.product.service.model.product.ProductInventoryWithProductDetails;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author 7cu
 */
@Repository
public interface ProductInventoryWithProductDetailsRepository extends PagingAndSortingRepository<ProductInventoryWithProductDetails, String>, JpaRepository<ProductInventoryWithProductDetails, String> {

    List<ProductInventoryWithProductDetails> findByProductId(@Param("productId") String productId);
}
