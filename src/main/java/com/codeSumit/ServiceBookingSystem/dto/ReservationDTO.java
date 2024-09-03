package com.codeSumit.ServiceBookingSystem.dto;





import java.util.Date;

import com.codeSumit.ServiceBookingSystem.entity.enums.ReservationStatus;
import com.codeSumit.ServiceBookingSystem.entity.enums.ReviewStatus;

import lombok.Data;

@Data
public class ReservationDTO {


    private long id;

    private Date bookDate;

    private String serviceName;

    private ReservationStatus reservationStatus;

    private ReviewStatus reviewStatus;

    private Long userId;

    private String userName;

    private Long companyId;

    private long adId;


}
