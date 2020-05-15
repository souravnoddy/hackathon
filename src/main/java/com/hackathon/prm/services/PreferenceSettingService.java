package com.hackathon.prm.services;

import com.hackathon.prm.dtos.PreferenceSubmitDto;
import com.hackathon.prm.entities.PreferenceEntity;
import com.hackathon.prm.entities.UserEntity;
import com.hackathon.prm.repositories.PreferenceRepository;
import com.hackathon.prm.repositories.UserRepository;
import com.hackathon.prm.utils.Utilities;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.QueryStringQueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PreferenceSettingService {
    @Autowired
    PreferenceRepository preferenceRepository;
    @Autowired
    UserRepository userRepository;

    public List<PreferenceEntity> searchPreference(String keyword) {

        QueryStringQueryBuilder queryStringQueryBuilder =
                QueryBuilders.queryStringQuery(Utilities.formatForRegex(keyword, true));

        queryStringQueryBuilder.field("preferenceName");

        List<PreferenceEntity> prefrence = preferenceRepository
                .search(
                        queryStringQueryBuilder,
                        PageRequest.of(0, 15,
                                Sort.by(Sort.Direction.ASC, "preferenceName")))
                .getContent();
        log.info("{}", prefrence);
        return prefrence;
    }


    public void addPreferenceToUser(PreferenceSubmitDto preferenceSubmitDto) {
        UserEntity user = getUser(preferenceSubmitDto.getUserId());

        List<PreferenceEntity> preferenceEntities = preferenceSubmitDto.getPreferenceIds()
                .stream()
                .map(preferenceId -> preferenceRepository.findById(preferenceId).orElse(null))
                .collect(Collectors.toList());
        if (user.getPreference() != null) {
            user.getPreference().addAll(preferenceEntities);
        } else {
            user.setPreference(preferenceEntities);
        }
        UserEntity save = userRepository.save(user);
        log.info("{}", save);
    }


    public List<PreferenceEntity> getPreferenceByUser(String userId) {
        UserEntity user = getUser(userId);
        return user.getPreference();
    }

    public UserEntity deletePreferenceByUser(PreferenceSubmitDto preferenceSubmitDto) {
        UserEntity user = getUser(preferenceSubmitDto.getUserId());
        List<PreferenceEntity> preference = user.getPreference();
        if (preference != null) {
            List<PreferenceEntity> collect = preference.stream().filter(p -> !preferenceSubmitDto.getPreferenceIds().contains(p.getId()))
                    .collect(Collectors.toList());
            user.setPreference(collect);
            user = userRepository.save(user);
        }
        return user;
    }


    private UserEntity getUser(String userId) {

        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        boolQueryBuilder.must(QueryBuilders.termQuery("userId", userId));

        System.out.println(boolQueryBuilder.toString());

        List<UserEntity> userEntities =
                userRepository
                        .search(
                                boolQueryBuilder, PageRequest.of(0, 1, Sort.by(Sort.Direction.ASC, "userId")))
                        .getContent();
        return userEntities.get(0);
    }


    public void addDummyPreferenceData() {

        List<PreferenceEntity> dummyData = new ArrayList<>();

        List<String> preference = Arrays.asList("Less Oily", "Medium Oily", "Less Spicy", "Moderate Spicy", "Spicy");

        preference.stream().forEach(p -> {
            PreferenceEntity build = PreferenceEntity.builder().preferenceName(p).build();
            PreferenceEntity save = preferenceRepository.save(build);
            System.out.println(save);
        });
    }

}
