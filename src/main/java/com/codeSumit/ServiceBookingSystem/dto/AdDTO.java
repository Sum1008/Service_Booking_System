package com.codeSumit.ServiceBookingSystem.dto;

import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.Data;

@Data
public class AdDTO {

      @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String serviceName;


    private String description;

    private Double price;

    private MultipartFile img;

   private byte[] returnedImg;

   private Long userId;

   private String companyName;


}
