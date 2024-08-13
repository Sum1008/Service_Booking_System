package com.codeSumit.ServiceBookingSystem.service.client;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codeSumit.ServiceBookingSystem.dto.AdDTO;
import com.codeSumit.ServiceBookingSystem.dto.AdDetailsForClientDTO;
import com.codeSumit.ServiceBookingSystem.entity.Ad;
import com.codeSumit.ServiceBookingSystem.entity.Reservation;
import com.codeSumit.ServiceBookingSystem.entity.User;
import com.codeSumit.ServiceBookingSystem.entity.enums.ReservationStatus;
import com.codeSumit.ServiceBookingSystem.entity.enums.ReviewStatus;
import com.codeSumit.ServiceBookingSystem.repository.AdRepository;
import com.codeSumit.ServiceBookingSystem.repository.ReservationRepository;
import com.codeSumit.ServiceBookingSystem.repository.UserRepository;
import com.codeSumit.ServiceBookingSystem.dto.ReservationDTO;
@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private AdRepository adRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    public List<AdDTO> getAllAds(){

        return adRepository.findAll().stream().map(Ad:: getAdDto).collect(Collectors.toList());
        
    }

    public List<AdDTO> searchAdByName(String name){
        return adRepository.findAllByServiceNameContaining(name).stream().map(Ad:: getAdDto).collect(Collectors.toList());
    }

    public boolean bookService(ReservationDTO reservationDTO){
        Optional<Ad> optionalAd=adRepository.findById(reservationDTO.getId());

        Optional<User> optionalUser=userRepository.findById(reservationDTO.getUserId());
        if(optionalAd.isPresent()&& optionalUser.isPresent()){
            Reservation reservation=new Reservation();
            reservation.setBookDate(reservationDTO.getBookDate());
            reservation.setReservationStatus(ReservationStatus.PENDING);
            reservation.setUser(optionalUser.get());
            reservation.setAd(optionalAd.get());

            reservation.setCompany(optionalAd.get().getUser());
            reservation.setReviewStatus(ReviewStatus.FALSE);

            reservationRepository.save(reservation);
            return true;

        }
        return false;

    }

    public AdDetailsForClientDTO getAdDetailsById(Long adId){
        Optional<Ad> optionalAd=adRepository.findById(adId);
        AdDetailsForClientDTO adDetailsForClientDTO=new AdDetailsForClientDTO();

        if(optionalAd.isPresent()){
            adDetailsForClientDTO.setAdDTO(optionalAd.get().getAdDto());

        }
        return adDetailsForClientDTO;
        
    }

    

}
