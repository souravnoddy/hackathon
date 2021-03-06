package com.hackathon.prm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hackathon.prm.dtos.RestaurantDto;
import com.hackathon.prm.services.RestaurantService;

@CrossOrigin(maxAge = 7200)
@RestController
@RequestMapping("v1/prm/restaurant")
public class RestaurantController {

	@Autowired
	private RestaurantService restaurantService;

	@CrossOrigin(origins = "http://localhost:8080")
	@PutMapping
	public ResponseEntity<?> updateColorCode(@RequestBody RestaurantDto restaurantDto) {
		restaurantService.updateColorCode(restaurantDto);
		return ResponseEntity.ok("success");
	}

}
