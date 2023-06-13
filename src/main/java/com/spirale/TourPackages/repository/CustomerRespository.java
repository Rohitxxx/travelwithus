package com.spirale.TourPackages.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spirale.TourPackages.entity.Customer;

public interface CustomerRespository extends JpaRepository<Customer, Integer> {
 
	Optional<Customer> findOneByEmailAndPassword(String email,String password);
	
	Optional<Customer> findByEmail(String email);
	
//	Optional<Customer> findByConfirmPassword(String confirmPassword);
	boolean existsByEmail(String email);
	
}
