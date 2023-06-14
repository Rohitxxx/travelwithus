package com.example.hotel_proj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hotel_proj.entity.Hotel;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Integer> {

}
