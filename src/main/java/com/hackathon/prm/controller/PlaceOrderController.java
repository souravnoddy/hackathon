package com.hackathon.prm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hackathon.prm.dtos.PlaceOrderDto;
import com.hackathon.prm.services.PlaceOrderService;

@CrossOrigin(maxAge = 7200)
@RestController
@RequestMapping("v1/prm/placeOrder")
public class PlaceOrderController {

	@Autowired
	private PlaceOrderService placeOrderService;

	@CrossOrigin(origins = "http://localhost:8080")
	@PostMapping
	public ResponseEntity<?> placeOrder(@RequestBody PlaceOrderDto placeOrderDto) {		
		return ResponseEntity.ok(placeOrderService.placeOrder(placeOrderDto));
	}

}
