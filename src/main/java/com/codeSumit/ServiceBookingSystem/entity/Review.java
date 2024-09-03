package com.codeSumit.ServiceBookingSystem.entity;

import java.util.Date;

import com.codeSumit.ServiceBookingSystem.dto.ReviewDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Date reviewData;

    private String review;

    private Long rating;

    @ManyToOne(fetch=FetchType.LAZY,optional = false )
    @JoinColumn(name="user_id",nullable = false)
    private User user;

    @ManyToOne(fetch=FetchType.LAZY,optional = false )
    @JoinColumn(name="ad_id",nullable = false)
    private Ad ad;


    public ReviewDTO getDto(){
        ReviewDTO reviewDTO=new ReviewDTO();

        reviewDTO.setId(id);
        reviewDTO.setReview(review);
        reviewDTO.setRating(rating);
        reviewDTO.setReviewData(reviewData);
        reviewDTO.setUserId(user.getId());
        reviewDTO.setClientName(user.getName());
        reviewDTO.setAdId(ad.getId());
        reviewDTO.setServiceName(ad.getServiceName());

        return reviewDTO;
    }
}
