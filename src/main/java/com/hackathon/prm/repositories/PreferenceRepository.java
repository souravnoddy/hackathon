package com.hackathon.prm.repositories;

import com.hackathon.prm.entities.PreferenceEntity;
import com.hackathon.prm.entities.UserEntity;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PreferenceRepository extends ElasticsearchRepository<PreferenceEntity, String> {

}
