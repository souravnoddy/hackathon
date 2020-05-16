package com.hackathon.prm.dtos;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PlaceOrderDto {

	private String userId;
	private String restaurantId;
	private String restaurantName;
	private String locationId;
	private String sourceId;
	private String sourceName;
	private List<OrderedDish> orderedDishes;
	private String totalAmount;
	private String currency;
	private String paymentGateway;
	private String orderStatus;

}
