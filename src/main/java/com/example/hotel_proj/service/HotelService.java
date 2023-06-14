package com.example.hotel_proj.service;



import org.springframework.beans.factory.annotation.Autowired;

import com.example.hotel_proj.entity.Hotel;
import com.example.hotel_proj.repository.HotelRepository;

public class HotelService {
	
	@Autowired
	private HotelRepository hotelrepository;
	public Hotel createHotel(Hotel hotel) {
		return hotelrepository.save(hotel);
	}

}
