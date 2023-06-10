package com.spirale.TourPackages.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spirale.TourPackages.entity.Booking;
import com.spirale.TourPackages.entity.TravelPackages;
import com.spirale.TourPackages.repository.BookingRepository;
import com.spirale.TourPackages.response.ResponseObject;
import com.spirale.TourPackages.service.BookingService;
import java.util.List;

@RestController
@RequestMapping("/book")
public class BookingController {

	@Autowired
	BookingService bookingService;
	
	
@PostMapping("/create")
public Booking addbooking(@RequestBody Booking book ) {
	return bookingService.create(book); 
	
	
}

@GetMapping("/getAll")
public List<Booking> getAllBooking() {
	return bookingService.getAll();
}

@PutMapping("/update/{bookingId}")
public ResponseObject updateBooking(@RequestBody Booking book) {
	return bookingService.updatepack(book);  
}
	
@GetMapping("/getOne/{bookingId}")
public Optional<Booking> getOne(@PathVariable Integer bookingId) {
	return bookingService.getOne(bookingId);
}


@DeleteMapping("/deletePack/{bookingId}")
public ResponseObject delete( @PathVariable Integer bookingId) {
	return bookingService.deletePackage(bookingId);
}
}
