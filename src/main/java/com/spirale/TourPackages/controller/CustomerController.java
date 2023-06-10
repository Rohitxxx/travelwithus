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
import com.spirale.TourPackages.entity.Customer;
import com.spirale.TourPackages.response.ResponseObject;
import com.spirale.TourPackages.service.CustomerService;
import java.util.List;

@RestController
@RequestMapping("/cus")
public class CustomerController {

     @Autowired
     CustomerService customerService;
     
 	
     @PostMapping("/create")
     public Customer addCustomer(@RequestBody Customer cus ) {
     	return customerService.create(cus); 
     	
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
