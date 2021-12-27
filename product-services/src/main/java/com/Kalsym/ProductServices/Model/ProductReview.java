package com.Kalsym.ProductServices.Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author 7cu
 */
@Getter
@Setter
@ToString
@Entity
@Table(name = "product_review")
@NoArgsConstructor
public class ProductReview implements Serializable {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private String reviewId;
    private String customerId;
    private int rating;
    private String review;
}
