package com.spirale.TourPackages.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spirale.TourPackages.entity.TravelPackages;
import com.spirale.TourPackages.repository.TravelPackegesRepository;
import com.spirale.TourPackages.response.ResponseObject;

@Service
public class TravelPackageService {
	@Autowired
	TravelPackegesRepository tavelPackageRepostory;
	
	public TravelPackages create(TravelPackages pack) {
		return tavelPackageRepostory.save(pack);
		
	}
	
	public java.util.List<TravelPackages> getAll() {
		return tavelPackageRepostory.findAll();
	}
	
	public Optional<TravelPackages> getOne(Integer packageId) {
		return tavelPackageRepostory.findById(packageId);

	
	}
	
	
	public ResponseObject deletePackage(Integer trvId) {
		Optional<TravelPackages> travel= tavelPackageRepostory.findById(trvId);
	      if(travel.isPresent()) {
	    	  tavelPackageRepostory.deleteById(trvId);
	    	  return new ResponseObject("Data deleted successfully",travel,"200");
	      }
	      else {
	    	  return new ResponseObject("Data not found",travel,"404");
	      }
}
	public ResponseObject updatepack(TravelPackages pack ) {
		Optional<TravelPackages> packageDetails= tavelPackageRepostory.findById(pack.getPackageId());
		if(packageDetails.isPresent() && pack.equals(packageDetails))
		{
			return new ResponseObject("Data already present",packageDetails,"ok");
		}
		else {
			TravelPackages save= tavelPackageRepostory.save(pack);
			return new ResponseObject("Data updated",save,"200");
		}
		
		
		
	}
}
