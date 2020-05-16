package com.hackathon.prm.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderedDish {

	private String dishId;
	private String dishName;
	private String price;
	private String currency;
	private String specialInstructions;

}
