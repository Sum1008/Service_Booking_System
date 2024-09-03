package com.codeSumit.ServiceBookingSystem.service.client;

import java.util.List;

import com.codeSumit.ServiceBookingSystem.dto.AdDTO;
import com.codeSumit.ServiceBookingSystem.dto.AdDetailsForClientDTO;
import com.codeSumit.ServiceBookingSystem.dto.ReservationDTO;
import com.codeSumit.ServiceBookingSystem.dto.ReviewDTO;

public interface ClientService {

    
    
    List<AdDTO> getAllAds();

    List<AdDTO> searchAdByName(String name);

    boolean bookService(ReservationDTO reservationDTO);

    AdDetailsForClientDTO getAdDetailsById(Long adId);

    List<ReservationDTO> getAllBookingByUserId(Long  userId);

    Boolean giveReview(ReviewDTO reviewDTO);
}
