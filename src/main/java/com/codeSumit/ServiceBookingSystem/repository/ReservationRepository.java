package com.codeSumit.ServiceBookingSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codeSumit.ServiceBookingSystem.entity.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation,Long> {


    List<Reservation> findAllByCompanyId(Long companyId);
    
    List<Reservation> findAllByUserId(Long userId);
    

}
