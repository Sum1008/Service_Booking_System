package com.codeSumit.ServiceBookingSystem.service.client;

import java.util.List;

import com.codeSumit.ServiceBookingSystem.dto.AdDTO;
import com.codeSumit.ServiceBookingSystem.dto.AdDetailsForClientDTO;
import com.codeSumit.ServiceBookingSystem.dto.ReservationDTO;

public interface ClientService {

    
    
    List<AdDTO> getAllAds();

    List<AdDTO> searchAdByName(String name);

    boolean bookService(ReservationDTO reservationDTO);

    AdDetailsForClientDTO getAdDetailsById(Long adId);
}
