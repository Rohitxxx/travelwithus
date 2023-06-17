package com.agency.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.agency.entity.Agency;

@Repository
public interface AgencyRepository  extends JpaRepository<Agency, Integer> {
		 
}

