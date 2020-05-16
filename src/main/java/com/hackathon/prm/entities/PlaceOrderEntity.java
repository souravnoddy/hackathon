package com.hackathon.prm.entities;

import java.util.List;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.hackathon.prm.dtos.OrderedDish;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder(toBuilder = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Document(indexName = "orders", type = "orders", createIndex = false)
public class PlaceOrderEntity {

	@Id
	private String id = UUID.randomUUID().toString();

	@Field(fielddata = true, type = FieldType.Keyword)
	private String userId;

	@Field(fielddata = true, type = FieldType.Keyword)
	private String restaurantId;

	@Field(fielddata = true, type = FieldType.Text)
	private String restaurantName;

	@Field(fielddata = true, type = FieldType.Keyword)
	private String locationId;

	@Field(fielddata = true, type = FieldType.Keyword)
	private String sourceId;

	@Field(fielddata = true, type = FieldType.Keyword)
	private String sourceName;

	@Field(fielddata = true, type = FieldType.Nested)
	private List<OrderedDish> orderedDishes;

	@Field(fielddata = true, type = FieldType.Keyword)
	private String totalAmount;

	@Field(fielddata = true, type = FieldType.Keyword)
	private String currency;

	@Field(fielddata = true, type = FieldType.Keyword)
	private String paymentGateway;

	@Field(fielddata = true, type = FieldType.Keyword)
	private String orderStatus;
}
