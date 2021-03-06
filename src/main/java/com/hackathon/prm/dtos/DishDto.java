package com.hackathon.prm.dtos;

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
public class DishDto {
	private String id;
	private String userId;
	private String restaurantId;
	private String sourceId;
	private String dishId;
	private int colorCode;
	private String specialInstructions;
}
