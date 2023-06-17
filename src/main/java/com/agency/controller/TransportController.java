package com.agency.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.agency.entity.Transport;
import com.agency.response.ResponseObj;
import com.agency.service.TransportService;


@RestController
public class TransportController {
	@Autowired
	TransportService service;
	
	@PostMapping("/created")
	public Transport addEmployee(@RequestBody Transport transport) {
		return service.createTransoport(transport);
		
	}
	@GetMapping("/fetchAll") public List<Transport> getAll(){ 
		  return service.getTransport(); }
	  
	@GetMapping("/fetchone/){TransportID}") public Optional<Transport>
	  getone(@PathVariable Integer transportId){ 
		  return service.getOne(transportId);
	}	  
	@DeleteMapping("/deleted/{transportId}")
		    public ResponseObj deletetransport(@PathVariable Integer transportId) {
		        return service.deleteTransport(transportId);
		    }

	 @PutMapping("/updated/{agencyId}")
		    public ResponseObj update(@RequestBody Transport book) {
		    return service.updatepack(book);  	  
	  
	  }



}