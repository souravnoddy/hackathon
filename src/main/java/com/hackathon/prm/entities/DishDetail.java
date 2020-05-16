package com.hackathon.prm.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder(toBuilder = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class DishDetail {
	
	private String dishId;
	private String dishName;
	private String description;
	private String price;
	private String currency;
	private int colorCode;
	private String specialInstruction;
	
}
