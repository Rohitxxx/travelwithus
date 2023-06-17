package com.agency.respository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.agency.entity.Transport;

@Repository
public interface TransportRepository 
	extends JpaRepository<Transport, Integer>{

}
