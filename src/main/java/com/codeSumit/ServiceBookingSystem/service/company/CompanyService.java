package com.codeSumit.ServiceBookingSystem.service.company;

import java.io.IOException;
import java.util.List;

import com.codeSumit.ServiceBookingSystem.dto.AdDTO;
import com.codeSumit.ServiceBookingSystem.dto.ReservationDTO;

public interface CompanyService {

    boolean postAd(Long userId,AdDTO adDTO) throws IOException;

    List<AdDTO> getAllAds(Long userId);

    AdDTO getAdById(Long adId);

    boolean updateAd(Long adId,AdDTO adDTO) throws IOException;

    public boolean deleteAd(Long adId);

    List<ReservationDTO> getAllAdBookings(Long companyId);

    boolean changeBookingStatus(Long bookingId,String status);

}
