package com.hackathon.prm.repositories;

import com.hackathon.prm.entities.RestaurantEntity;

import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DishRepository extends ElasticsearchRepository<RestaurantEntity, String> {
	
//	 @Query("{\"match\": {\"name\": {\"query\": \"?0\"}}}")
	// DishEntity findByRestaurantIdandDishId(String restaurantId, String dishId);
}
