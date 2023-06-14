package com.example.hotel_proj.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.hotel_proj.entity.Hotel;
import com.example.hotel_proj.service.HotelService;
@RestController
public class Controller {
	@Autowired
	HotelService service;
	
	@PostMapping("/create")
	public Hotel addHotel(@RequestBody Hotel hotel) {
		return service.createHotel(hotel);
		
	}
	
}
