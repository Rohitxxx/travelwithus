package com.spirale.TourPackages.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spirale.TourPackages.entity.Customer;

public interface CustomerRespository extends JpaRepository<Customer, Integer> {

}
