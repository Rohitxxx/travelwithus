package com.agency.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.agency.entity.Agency;
import com.agency.response.ResponseObj;
import com.agency.respository.AgencyRepository;

@Service
public class AgencyService {

    private final AgencyRepository agencyRepository;

    @Autowired
    public AgencyService(AgencyRepository agencyRepository) {
        this.agencyRepository = agencyRepository;
    }

    public Agency createAgency(Agency agency) {
        return agencyRepository.save(agency);
    }

    public List<Agency> getAgency() {
        return agencyRepository.findAll();
    }

    public Optional<Agency> getOne(Integer agencyId) {
        return agencyRepository.findById(agencyId);
    }

    public ResponseObj deleteAgency(Integer agencyId) {
        Optional<Agency> agency = agencyRepository.findById(agencyId);
        if (agency.isPresent()) {
            agencyRepository.deleteById(agencyId);
            return new ResponseObj("Data deleted", agency.get(), "200");
        } else {
            return new ResponseObj("Agency not found", null, "404");
        }
    }
    public ResponseObj updatepack(Agency agency ) {
		Optional<Agency> agencyDetails= agencyRepository.findById(agency.getAgencyId());
		Agency agen = agencyDetails.get();
		if(agencyDetails.isPresent() && agency.equals(agen))
			
			
		{
			
			return new ResponseObj("Data already present",agencyDetails,"404");
		}
		else {
			Agency save= agencyRepository.save(agency);
			return new ResponseObj("Data updated",save,"200");
		}
		
		
		
	}
   
        
    }





