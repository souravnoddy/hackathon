package com.hackathon.prm.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackathon.prm.dtos.DishDto;
import com.hackathon.prm.entities.DishEntity;
import com.hackathon.prm.repositories.DishRepository;

@Service
public class DishService {
	@Autowired
	DishRepository dishRepository;

	public DishEntity getDish(DishDto dishDto) {

		return null;
	}

}
