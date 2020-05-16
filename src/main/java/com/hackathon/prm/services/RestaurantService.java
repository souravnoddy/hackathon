package com.hackathon.prm.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackathon.prm.dtos.RestaurantDto;
import com.hackathon.prm.entities.RestaurantEntity;
import com.hackathon.prm.repositories.RestaurantRepository;

@Service
public class RestaurantService {
	@Autowired
	RestaurantRepository restaurantRepository;

	public void updateColorCode(RestaurantDto restaurantDto) {

		RestaurantEntity restaurantEntity = restaurantRepository.findById(restaurantDto.getId()).get();
		restaurantEntity.setColorCode(restaurantDto.getColorCode());
		restaurantRepository.save(restaurantEntity);

	}

}