package com.spirale.TourPackages.service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
<<<<<<< HEAD
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
=======
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
>>>>>>> e8607e90e2220c4f0312cc533843569cb5ad52ab
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.spirale.TourPackages.dto.LoginDto;
import com.spirale.TourPackages.entity.Booking;
import com.spirale.TourPackages.entity.Customer;
import com.spirale.TourPackages.repository.CustomerRespository;
import com.spirale.TourPackages.response.ResponseObject;
import com.spirale.TourPackages.util.UserDetailsImpl;

import io.jsonwebtoken.lang.Collections;

@Service
public class CustomerService implements UserDetailsService {

	@Autowired
	CustomerRespository customerRespository;
<<<<<<< HEAD

	public ResponseObject create(Customer cus) {

		BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
		String encryptedpwd = bcrypt.encode(cus.getPassword());
		cus.setPassword(encryptedpwd);
		cus.setConfirmPassword(encryptedpwd);
		customerRespository.save(cus);
		return new ResponseObject("SignUp successful", cus, "200");

	}

	public java.util.List<Customer> getAll() {
		return customerRespository.findAll();
	}

=======
	
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
	
	
>>>>>>> e8607e90e2220c4f0312cc533843569cb5ad52ab
	public Optional<Customer> getOne(Integer customerId) {
		return customerRespository.findById(customerId);

	}

	public ResponseObject deleteCustomer(Integer customerId) {
		Optional<Customer> cus = customerRespository.findById(customerId);
		if (cus.isPresent()) {
			customerRespository.deleteById(customerId);
			return new ResponseObject("Data deleted successfully", cus, "200");
		} else {
			return new ResponseObject("Data not found", cus, "404");
		}
	}

<<<<<<< HEAD
	public ResponseObject updateCustomer(Customer cus) {
		Optional<Customer> customerDetails = customerRespository.findById(cus.getCustomerId());
		if (customerDetails.isPresent() && cus.equals(customerDetails)) {
			return new ResponseObject("Data already present", customerDetails, "ok");
		} else {
			Customer save = customerRespository.save(cus);
			return new ResponseObject("Data updated", save, "200");
		}

	}
=======



>>>>>>> e8607e90e2220c4f0312cc533843569cb5ad52ab

	public boolean existsByEmail(String email) {
		return customerRespository.existsByEmail(email);
	}

<<<<<<< HEAD
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
		Optional<Customer> customer = customerRespository.findByEmail(username);
		if (customer.isPresent()) {
			Customer cus = customer.get();
			/*
			 * LoginDto loginDto; String password= loginDto.getPassword(); String
			 * encodedPassword= cus.getPassword(); Boolean
			 * isPassRight=bcrypt.matches(password, encodedPassword);
			 */

//			if(isPassRight && loginDto.getEmail().equals(cus.getEmail()))
//				  return new ResponseObject("LOGIN SuccessFull",loginDto,"200");
			// Create a UserDetailsImpl object based on the retrieved customer details
			UserDetails userDetails = new UserDetailsImpl(cus.getEmail(), cus.getPassword(), new ArrayList<>());
			return userDetails;
		}else {
		throw new UsernameNotFoundException("User not found with username: " + username);
	}
	}
	/*
	 * public ResponseObject confirmUser(LoginDto loginDto) { BCryptPasswordEncoder
	 * bcrypt=new BCryptPasswordEncoder();
	 * 
	 * Optional<Customer>
	 * dbUser=customerRespository.findByEmail(loginDto.getEmail());
	 * if(dbUser.isPresent()) { Customer cusDetail=dbUser.get();
	 * 
	 * String password= loginDto.getPassword(); String encodedPassword=
	 * cusDetail.getPassword(); Boolean isPassRight=bcrypt.matches(password,
	 * encodedPassword);
	 * 
	 * if(isPassRight && loginDto.getEmail().equals(cusDetail.getEmail())) return
	 * new ResponseObject("LOGIN SuccessFull",loginDto,"200"); else return new
	 * ResponseObject("User name or password wrong",loginDto,"404"); } return new
	 * ResponseObject("User not found",loginDto,"404"); }
	 */

=======




	

	
>>>>>>> e8607e90e2220c4f0312cc533843569cb5ad52ab
}
