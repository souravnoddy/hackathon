package com.hackathon.prm.repositories;

import com.hackathon.prm.entities.RestaurantEntity;

import java.util.List;

import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DishRepository extends ElasticsearchRepository<RestaurantEntity, String> {
	
	 @Query("{\"match\": {\"userId\": {\"query\": \"?0\"}}}")
	 List<RestaurantEntity> findByDishDto(String userId);
}
