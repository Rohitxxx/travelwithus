package com.spirale.TourPackages.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spirale.TourPackages.entity.Booking;
import com.spirale.TourPackages.entity.Customer;
import com.spirale.TourPackages.repository.CustomerRespository;
import com.spirale.TourPackages.response.ResponseObject;

@Service
public class CustomerService {

	@Autowired
	CustomerRespository customerRespository;
	
	public Customer create(Customer cus) {
		
		return customerRespository.save(cus);
		
	}
	
	public java.util.List<Customer> getAll() {
		return customerRespository.findAll();
	}
	
	public Optional<Customer> getOne(Integer customerId) {
		return customerRespository.findById(customerId);

	
	}
	
	
	public ResponseObject deleteCustomer(Integer customerId) {
		Optional<Customer> cus= customerRespository.findById(customerId);
	      if(cus.isPresent()) {
	    	  customerRespository.deleteById(customerId);
	    	  return new ResponseObject("Data deleted successfully",cus,"200");
	      }
	      else {
	    	  return new ResponseObject("Data not found",cus,"404");
	      }
}

	public ResponseObject updateCustomer(Customer cus ) {
		Optional<Customer> customerDetails= customerRespository.findById(cus.getCustomerId());
		if(customerDetails.isPresent() && cus.equals(customerDetails))
		{
			return new ResponseObject("Data already present",customerDetails,"ok");
		}
		else {
			Customer save= customerRespository.save(cus);
			return new ResponseObject("Data updated",save,"200");
		}
		
		
		
	}
}
