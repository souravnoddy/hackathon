package com.hackathon.prm.dtos;

import lombok.Data;

import java.util.List;
@Data
public class PreferenceSubmitDto {
    private String userId;
    private List<String> preferenceIds;
}
