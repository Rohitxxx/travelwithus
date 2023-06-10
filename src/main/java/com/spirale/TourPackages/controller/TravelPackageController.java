package com.spirale.TourPackages.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spirale.TourPackages.entity.TravelPackages;
import com.spirale.TourPackages.response.ResponseObject;
import com.spirale.TourPackages.service.TravelPackageService;
import java.util.List;


@RestController
public class TravelPackageController {
	@Autowired
	TravelPackageService service;
	
	@GetMapping("/hi")
	public String hii()
{
	 return "radhe krishna";	 
}
	
	
@PostMapping("/create")
public TravelPackages addPackage(@RequestBody TravelPackages pack ) {
	return service.create(pack); 
	
}

@GetMapping("/getAll")
public List<TravelPackages> getAllPackage() {
	return service.getAll();
}

@PutMapping("/update/{packageId}")
public ResponseObject updatePackaGE(@RequestBody TravelPackages pack) {
	return service.updatepack(pack);  
}
	
@GetMapping("/getOne/{packageId}")
public Optional<TravelPackages> getOne(@PathVariable Integer packageId) {
	return service.getOne(packageId);
}


@DeleteMapping("/deletePack/{packageId}")
public ResponseObject delete( @PathVariable Integer packageId) {
	return service.deletePackage(packageId);
}
}

