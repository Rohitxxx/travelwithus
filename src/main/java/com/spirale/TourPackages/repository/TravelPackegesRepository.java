package com.spirale.TourPackages.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spirale.TourPackages.entity.TravelPackages;

@Repository
public interface TravelPackegesRepository extends JpaRepository<TravelPackages, Integer>{

}
