package com.spirale.TourPackages.service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.spirale.TourPackages.dto.LoginDto;
import com.spirale.TourPackages.entity.Booking;
import com.spirale.TourPackages.entity.Customer;
import com.spirale.TourPackages.repository.CustomerRespository;
import com.spirale.TourPackages.response.ResponseObject;

@Service
public class CustomerService {

	@Autowired
	CustomerRespository customerRespository;
	
	public ResponseObject create(Customer cus) {
		
		BCryptPasswordEncoder bcrypt=new BCryptPasswordEncoder();
		String encryptedpwd=bcrypt.encode(cus.getPassword());
		cus.setPassword(encryptedpwd);
		cus.setConfirmPassword(encryptedpwd);
		 customerRespository.save(cus);
		return new ResponseObject("SignUp successful",cus,"200");
		
	}
	
	
	
	
	
	public ResponseObject  confirmUser(LoginDto loginDto) 
	{
	BCryptPasswordEncoder bcrypt=new BCryptPasswordEncoder();
	
		Optional<Customer> dbUser=customerRespository.findByEmail(loginDto.getEmail());
		if(dbUser.isPresent()) {
			Customer cusDetail=dbUser.get();
			
			String password= loginDto.getPassword();
			String encodedPassword= cusDetail.getPassword();
			Boolean isPassRight=bcrypt.matches(password, encodedPassword);
			
			if(isPassRight && loginDto.getEmail().equals(cusDetail.getEmail()))
			      return new ResponseObject("LOGIN SuccessFull",loginDto,"200");
			else
				return  new ResponseObject("User name or password wrong",loginDto,"404");
		}
		return new ResponseObject("User not found",loginDto,"404");
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





	public boolean existsByEmail(String email) {
		return customerRespository.existsByEmail(email);
	}





	

	
}
