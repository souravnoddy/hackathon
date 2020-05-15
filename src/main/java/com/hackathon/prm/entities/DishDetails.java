package com.hackathon.prm.entities;

import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

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
public class DishDetails {

	@Field(fielddata = true, type = FieldType.Text)
	private String dishId;

	@Field(fielddata = true, type = FieldType.Text)
	private String dishName;
	
	@Field(fielddata = true, type = FieldType.Text)
	private String description;

	@Field(fielddata = true, type = FieldType.Keyword)
	private String sourceId;

	@Field(fielddata = true, type = FieldType.Keyword)
	private String sourceName;

	@Field(fielddata = true, type = FieldType.Text)
	private String price;

    @Field(fielddata = true,type = FieldType.Keyword)
    private String currency;
    
	@Field(fielddata = true, type = FieldType.Integer)
	private int colorCode;

	@Field(fielddata = true, type = FieldType.Text)
	private int specialInstruction;

}
