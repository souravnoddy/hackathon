package com.hackathon.prm.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackathon.prm.dtos.PlaceOrderDto;
import com.hackathon.prm.entities.PlaceOrderEntity;
import com.hackathon.prm.repositories.PlaceOrderRepository;

@Service
public class PlaceOrderService {
	@Autowired
	PlaceOrderRepository placeOrderRepository;

	public String placeOrder(PlaceOrderDto placeOrderDto) {

		PlaceOrderEntity placeOrderEntity = new PlaceOrderEntity();
		BeanUtils.copyProperties(placeOrderDto, placeOrderEntity);
		placeOrderRepository.save(placeOrderEntity);
		return placeOrderEntity.getId();

	}

}