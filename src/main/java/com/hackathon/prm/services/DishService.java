package com.hackathon.prm.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackathon.prm.dtos.DishDto;
import com.hackathon.prm.entities.RestaurantEntity;
import com.hackathon.prm.repositories.DishRepository;

@Service
public class DishService {
	@Autowired
	DishRepository dishRepository;

	public RestaurantEntity getDish(DishDto dishDto) {

		List<RestaurantEntity> restaurantEntities = dishRepository.findByDishDto(dishDto.getUserId());

		System.out.println("restaurantEntities ::" + restaurantEntities);
		return null;
	}

	/*
	 * public void addPreference() {
	 * 
	 * List<PreferenceEntity> dummyData = new ArrayList<>();
	 * 
	 * List<String> preference = Arrays.asList("Less Oily", "Medium Oily",
	 * "Less Spicy", "Moderate Spicy", "Spicy");
	 * 
	 * preference.stream().forEach(p -> { PreferenceEntity build =
	 * PreferenceEntity.builder().preferenceName(p).build(); PreferenceEntity save =
	 * preferenceRepository.save(build); System.out.println(save); }); }
	 * 
	 * public List<PreferenceEntity> submitPreference(PreferenceSubmitDto
	 * preferenceSubmitDto) { // TODO: 2020-05-15 return null; }
	 */
}
