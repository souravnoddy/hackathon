package com.hackathon.prm.services;

import com.hackathon.prm.dtos.PreferenceSubmitDto;
import com.hackathon.prm.entities.PreferenceEntity;
import com.hackathon.prm.repositories.PreferenceRepository;
import com.hackathon.prm.utils.Utilities;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.QueryStringQueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class PreferenceSettingService {
    @Autowired
    PreferenceRepository preferenceRepository;

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
        System.out.println(prefrence);
        return prefrence;
    }


    public void addPreference() {

        List<PreferenceEntity> dummyData = new ArrayList<>();

        List<String> preference = Arrays.asList("Less Oily", "Medium Oily", "Less Spicy", "Moderate Spicy", "Spicy");

        preference.stream().forEach(p -> {
            PreferenceEntity build = PreferenceEntity.builder().preferenceName(p).build();
            PreferenceEntity save = preferenceRepository.save(build);
            System.out.println(save);
        });
    }

    public List<PreferenceEntity> submitPreference(PreferenceSubmitDto preferenceSubmitDto) {
        // TODO: 2020-05-15
        return null;
    }
}
