package com.hackathon.prm.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.hackathon.prm.dtos.DishDto;
import com.hackathon.prm.entities.DishDetail;
import com.hackathon.prm.entities.RestaurantEntity;
import com.hackathon.prm.repositories.DishRepository;

@Service
public class DishService {
	@Autowired
	DishRepository dishRepository;

	public RestaurantEntity getDish(DishDto dishDto) {

		RestaurantEntity restaurantEntity = dishRepository.findByDishDtoCustomQuery(dishDto.getUserId(),
				dishDto.getRestaurantId(), dishDto.getSourceId());
		if (restaurantEntity != null) {
			DishDetail dishDetail = getDishDetail(restaurantEntity.getDishDetails(), dishDto.getDishId());
			restaurantEntity.getDishDetails().clear();
			restaurantEntity.getDishDetails().add(dishDetail);
			return restaurantEntity;
		}
		return null;
	}

	private DishDetail getDishDetail(List<DishDetail> dishDetails, String dishId) {
		if (!CollectionUtils.isEmpty(dishDetails)) {
			return dishDetails.stream().filter(dishDetail -> dishDetail.getDishId().equals(dishId)).findFirst().get();
		}
		return null;
	}

	public void updateDish(DishDto dishDto) {

		RestaurantEntity restaurantEntity = dishRepository.findById(dishDto.getId()).get();
		List<DishDetail> dishDetails = restaurantEntity.getDishDetails();
		DishDetail orgDishDetail = dishDetails.stream()
				.filter((dishDetail) -> dishDetail.getDishId().equals(dishDto.getDishId())).findFirst().get();
		DishDetail modDishDetail = new DishDetail();
		BeanUtils.copyProperties(orgDishDetail, modDishDetail);
		modDishDetail.setColorCode(dishDto.getColorCode());
		modDishDetail.setSpecialInstructions(dishDto.getSpecialInstructions());
		dishDetails.remove(orgDishDetail);
		dishDetails.add(modDishDetail);
		restaurantEntity.setDishDetails(dishDetails);
		dishRepository.save(restaurantEntity);

	}

}