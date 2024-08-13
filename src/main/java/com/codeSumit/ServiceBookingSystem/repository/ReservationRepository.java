package com.codeSumit.ServiceBookingSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codeSumit.ServiceBookingSystem.entity.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation,Long> {

    

}
