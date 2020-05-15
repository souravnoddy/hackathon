package com.hackathon.prm.controller;

import com.hackathon.prm.dtos.PreferenceSubmitDto;
import com.hackathon.prm.entities.PreferenceEntity;
import com.hackathon.prm.services.PreferenceSettingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/v1/prm")
public class PreferenceSettingController {
    @Autowired
    private PreferenceSettingService preferenceSettingService;

    @GetMapping("/searchpreference")
    public ResponseEntity<?> searchPreference(@RequestParam("keyword") String keyword) {
        List<PreferenceEntity> searchPreference = preferenceSettingService.searchPreference(keyword);
        return ResponseEntity.ok(searchPreference);
    }

    @PostMapping("/submitPreference")
    public ResponseEntity<?> submitPreference(@RequestBody PreferenceSubmitDto preferenceSubmitDto) {
        List<PreferenceEntity> searchPreference = preferenceSettingService.submitPreference(preferenceSubmitDto);
        return ResponseEntity.ok().build();
    }
}
