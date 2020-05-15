package com.hackathon.prm.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hackathon.prm.dtos.UserDetails;
import com.hackathon.prm.entities.UserEntity;
import com.hackathon.prm.repositories.UserRepository;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class UserServices {

    @Autowired private UserRepository userRepository;

    public ResponseEntity<?> validateLogin(UserDetails userDetails) {
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        boolQueryBuilder.must(QueryBuilders.termQuery("userId", userDetails.getUserId()));
        boolQueryBuilder.must(QueryBuilders.termQuery("password", userDetails.getPassword()));

        System.out.println(boolQueryBuilder.toString());

        List<UserEntity> userEntities =
                userRepository
                        .search(
                                boolQueryBuilder, PageRequest.of(0, 1, Sort.by(Sort.Direction.ASC, "userId")))
                        .getContent();
        if (CollectionUtils.isEmpty(userEntities)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User Not Valid");
        }

        return ResponseEntity.ok().build();
    }

    public UserEntity addUser(UserDetails userDetails) {
        UserEntity userEntity = new ObjectMapper().convertValue(userDetails, UserEntity.class);
        UserEntity save = userRepository.save(userEntity);
        return save;
    }
}
