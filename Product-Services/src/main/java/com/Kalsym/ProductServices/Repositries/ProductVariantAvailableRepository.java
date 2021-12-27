package com.Kalsym.ProductServices.Repositries;

import com.Kalsym.ProductServices.Model.ProductVariantAvailable;
import com.Kalsym.ProductServices.Model.*;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author 7cu
 */
@Repository
public interface ProductVariantAvailableRepository extends  JpaRepository<ProductVariantAvailable, String> {

    
}
