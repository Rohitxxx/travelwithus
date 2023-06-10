package com.spirale.TourPackages.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spirale.TourPackages.entity.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer>  {
//update Booking set customerId=17,packageId=21 where bookingId=20
}
