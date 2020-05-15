package com.hackathon.prm.repositories;

import com.hackathon.prm.entities.RestaurantEntity;

import java.util.List;

import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DishRepository extends ElasticsearchRepository<RestaurantEntity, String> {
	
	 @Query("{\n" + 
	 		"  \"bool\": {\n" + 
	 		"    \"must\": [\n" + 
	 		"      {\n" + 
	 		"        \"match\": {\n" + 
	 		"          \"userId\": \"?0\"\n" + 
	 		"        }\n" + 
	 		"      },\n" + 
	 		"      {\n" + 
	 		"        \"match\": {\n" + 
	 		"          \"restaurantId\": \"?1\"\n" + 
	 		"        }\n" + 
	 		"      },\n" + 
	 		"      {\n" + 
	 		"        \"match\": {\n" + 
	 		"         \"sourceId\": \"?2\"\n" + 
	 		"        }\n" + 
	 		"      }\n" + 
	 		"    ]\n" + 
	 		"  }\n" + 
	 		"}")
	 RestaurantEntity findByDishDtoCustomQuery(String userId, String restaurantId, String sourceId);
}
