package com.Kalsym.ProductServices.Repositries;

import com.Kalsym.ProductServices.Model.ProductVariant;
import com.Kalsym.ProductServices.Model.*;
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
public interface ProductVariantRepository extends  JpaRepository<ProductVariant, String> {

   
}
