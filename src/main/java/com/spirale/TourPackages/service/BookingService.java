package com.spirale.TourPackages.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spirale.TourPackages.entity.Booking;
import com.spirale.TourPackages.entity.TravelPackages;
import com.spirale.TourPackages.repository.BookingRepository;
import com.spirale.TourPackages.response.ResponseObject;

@Service
public class BookingService {

	@Autowired
	BookingRepository bookingRepository;
	
	public Booking create(Booking book) {
		
			return bookingRepository.save(book);
			
		}
		
		public java.util.List<Booking> getAll() {
			return bookingRepository.findAll();
		}
		
		public Optional<Booking> getOne(Integer bookingId) {
			return bookingRepository.findById(bookingId);

		
		}
		
		
		public ResponseObject deletePackage(Integer bookingId) {
			Optional<Booking> book= bookingRepository.findById(bookingId);
		      if(book.isPresent()) {
		    	  bookingRepository.deleteById(bookingId);
		    	  return new ResponseObject("Data deleted successfully",book,"200");
		      }
		      else {
		    	  return new ResponseObject("Data not found",book,"404");
		      }
	}

		public ResponseObject updatepack(Booking book ) {
			Optional<Booking> bookingDetails= bookingRepository.findById(book.getBookingId());
			if(bookingDetails.isPresent() && book.equals(bookingDetails))
			{
				return new ResponseObject("Data already present",bookingDetails,"ok");
			}
			else {
				Booking save= bookingRepository.save(book);
				return new ResponseObject("Data updated",save,"200");
			}
			
			
			
		}
		
	}


