package com.spirale.TourPackages.controller;

import java.util.Optional;

import javax.naming.AuthenticationException;
import javax.validation.Valid;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spirale.TourPackages.dto.LoginDto;
import com.spirale.TourPackages.entity.Booking;
import com.spirale.TourPackages.entity.Customer;
import com.spirale.TourPackages.response.ResponseObject;
import com.spirale.TourPackages.service.CustomerService;
import com.spirale.TourPackages.util.JwtResponse;
import com.spirale.TourPackages.util.JwtUtil;

import java.util.List;

@RestController
@RequestMapping("/user")
public class CustomerController {
	
	@Autowired
	JwtUtil jwtUtil;
	
	@Autowired
	AuthenticationManager authenticationManager;
	

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
     public ResponseEntity<JwtResponse> authenticateUser(@RequestBody LoginDto loginDto) throws Exception{
		try {
			
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword()));
			
		}catch(UsernameNotFoundException e)
		{
			e.printStackTrace();
			throw new Exception("Bad credential");
		}catch(BadCredentialsException e)
		{
			e.printStackTrace();
			throw new Exception("Bad credentials");
		}
		//fine area  
		
		UserDetails UserDetails= customerService.loadUserByUsername(loginDto.getEmail());
		
	String token=	jwtUtil.generateToken(UserDetails);
	
	return ResponseEntity.ok(new JwtResponse(token));
		
     }
    	 
     
		/*
		 * @PostMapping("/authenticateUsers") public ResponseObject
		 * authenticateUser(@RequestBody LoginDto loginDto) { try {
		 * org.springframework.security.core.Authentication authentication =
		 * authenticationManager.authenticate( new
		 * UsernamePasswordAuthenticationToken(loginDto.getEmail(),
		 * loginDto.getPassword()) );
		 * SecurityContextHolder.getContext().setAuthentication(authentication); String
		 * token = jwtTokenUtil.generateToken(authentication); ResponseObject
		 * confirmUserResponse = customerService.confirmUser(loginDto);
		 * 
		 * if (confirmUserResponse.getStatus().equalsIgnoreCase("200")) { return new
		 * ResponseObject("Login successful", token, "200"); } else { return
		 * confirmUserResponse; } } catch (Exception e) { return new
		 * ResponseObject("Invalid email or password", null, "404"); } }
		 */
    	 
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
