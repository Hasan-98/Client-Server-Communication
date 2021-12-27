package com.Kalsym.ProductServices.Repositries;


import com.Kalsym.ProductServices.Model.ProductReview;
import com.Kalsym.ProductServices.Model.*;
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
public interface ProductReviewRepository extends JpaRepository<ProductReview, String> {

  
}
