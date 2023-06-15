package com.example.hotelproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.hotelproject.entity.Food;
import com.example.hotelproject.response.ResponseObject;
import com.example.hotelproject.service.FoodService;

@RestController
public class FoodController {

	@Autowired
	FoodService service;
	
	@PostMapping("/foodcreate")
	public Food addFood(@RequestBody Food food) {
		return service.createFood(food);
		
	}
	@DeleteMapping("/deleteFood/{id}")
	public ResponseObject delete( @PathVariable Integer id) {
		return service.deleteFood(id);
	}
	
	@GetMapping("/fetchAll")
	public java.util.List<Food> getAllFood() {
		return service.getAll();
	}
}
