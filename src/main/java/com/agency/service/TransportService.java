package com.agency.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agency.entity.Agency;
import com.agency.entity.Transport;
import com.agency.response.ResponseObj;
import com.agency.respository.TransportRepository;

@Service
public class TransportService {
@Autowired
      private com.agency.respository.TransportRepository transportRepository;
	    public Transport createTransoport(Transport transport) {
		return transportRepository.save(transport);
		// TODO Auto-generated method stub	
	}
	    public List<Transport> getTransport() {
	        return transportRepository.findAll();
	    }

	    public Optional<Transport> getOne(Integer transportId) {
	        return transportRepository.findById(transportId);
	    }

	    public ResponseObj deleteTransport(Integer transportId) {
	        Optional<Transport> transport = transportRepository.findById(transportId);
	        if (transport.isPresent()) {
	            transportRepository.deleteById(transportId);
	            return new ResponseObj("Data deleted", transport.get(), "200");
	        } else {
	            return new ResponseObj("Transport not found", null, "404");
	        }
	    }

	    public ResponseObj updatepack(Transport transport ) {
			Optional<Transport> transportDetails= transportRepository.findById(transport.getTransportId());
			Transport trans = transportDetails.get();
			if(transportDetails.isPresent() && transport.equals(transport))
			{
				
				return new ResponseObj("Data already present",transportDetails,"ok");
			}
			else {
				Transport save= transportRepository.save(transport);
				return new ResponseObj("Data updated",save,"200");
	        }
	    }
	}

