package com.hackathon.prm.repositories;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.hackathon.prm.entities.PlaceOrderEntity;

@Repository
public interface PlaceOrderRepository extends ElasticsearchRepository<PlaceOrderEntity, String> {

}
