package com.hackathon.prm.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.List;
import java.util.UUID;

@Builder(toBuilder = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Document(indexName = "restaurant", type = "restaurant", createIndex = false)
public class RestaurantEntity {

    @Id
    private String id = UUID.randomUUID().toString();

    @Field(fielddata = true,type = FieldType.Keyword)
    private String userId;
   
    @Field(fielddata = true,type = FieldType.Keyword)
    private String restaurantId;
    
    @Field(fielddata = true,type = FieldType.Text)
    private String restaurantName;
    
    @Field(fielddata = true,type = FieldType.Nested)
    private List<DishDetails> dishes;
 
}
