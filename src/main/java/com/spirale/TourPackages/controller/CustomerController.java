package com.spirale.TourPackages.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spirale.TourPackages.dto.LoginDto;
import com.spirale.TourPackages.entity.Booking;
import com.spirale.TourPackages.entity.Customer;
import com.spirale.TourPackages.response.ResponseObject;
import com.spirale.TourPackages.service.CustomerService;
import com.spirale.TourPackages.util.JwtTokenUtil;

import java.util.List;

@RestController
@RequestMapping("/user")
public class CustomerController {
	
	private final AuthenticationManager authenticationManager ;
	private final JwtTokenUtil jwtTokenUtil;
	
	public CustomerController(AuthenticationManager authenticationManager, JwtTokenUtil jwtTokenUtil) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
    }
	

     @Autowired
     CustomerService customerService;
     
     
 	
     @PostMapping("/create")
     public ResponseObject addCustomer(@Valid @RequestBody Customer cus ) {
    	 //check of the password matches the confirm password
    	 if(!cus.getPassword().equals( cus.getConfirmPassword())) {
    		 return  new ResponseObject("Password and confirm password do not match",cus,"404");
    	 }
    	 
    	 //check if the email address is already exists
    	 
    	 if(customerService.existsByEmail(cus.getEmail())) {
    		 return new ResponseObject("Email is already taken please use another",cus,"404");
    		 
    	 }
    	 
    	 
    	 else {
    	return customerService.create(cus);
    	 }
     	 
     	
     }
     @PostMapping("/authenticateUsers")
     
    	 public ResponseObject authenticateUser(@RequestBody LoginDto loginDto)
     {
    	 
    	 try {
    		 org.springframework.security.core.Authentication authentication=authenticationManager.authenticate(
    				 new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword())
    				 );
    		 SecurityContextHolder.getContext().setAuthentication(authentication);
    	 
    	 return customerService.confirmUser(loginDto);
     }
     

     @GetMapping("/getAll")
     public List<Customer> getAllCustomer() {
     	return customerService.getAll();
     }

     @PutMapping("/update/{customerId}")
     public ResponseObject updateCustomer(@RequestBody Customer cus) {
     	return customerService.updateCustomer(cus);  
     }
     	
     @GetMapping("/getOne/{customerId}")
     public Optional<Customer> getOne(@PathVariable Integer customerId) {
     	return customerService.getOne(customerId);
     }


     @DeleteMapping("/deletePack/{customerId}")
     public ResponseObject deleteCustomer( @PathVariable Integer customerId) {
     	return customerService.deleteCustomer(customerId);
     }

}
