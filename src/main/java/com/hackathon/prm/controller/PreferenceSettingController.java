package com.hackathon.prm.controller;

import com.hackathon.prm.dtos.PreferenceSubmitDto;
import com.hackathon.prm.entities.PreferenceEntity;
import com.hackathon.prm.entities.UserEntity;
import com.hackathon.prm.services.PreferenceSettingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@CrossOrigin(maxAge = 7200)
@RestController
@RequestMapping("/v1/prm")
public class PreferenceSettingController {
    @Autowired
    private PreferenceSettingService preferenceSettingService;

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/searchpreference")
    public ResponseEntity<?> searchPreference(@RequestParam("keyword") String keyword) {
        List<PreferenceEntity> searchPreference = preferenceSettingService.searchPreference(keyword);
        return ResponseEntity.ok(searchPreference);
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/searchpreferenceByUser")
    public ResponseEntity<?> searchPreferenceByUser(@RequestParam("userId") String userId) {
        List<PreferenceEntity> searchPreference = preferenceSettingService.getPreferenceByUser(userId);
        return ResponseEntity.ok(searchPreference);
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping("/addPreferenceByUser")
    public ResponseEntity<?> submitPreferenceByUser(@RequestBody PreferenceSubmitDto preferenceSubmitDto) {
        preferenceSettingService.addPreferenceToUser(preferenceSubmitDto);
        return ResponseEntity.ok().build();
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @DeleteMapping("/deletePreferenceByUser")
    public ResponseEntity<?> deletePreferenceByuser(@RequestBody PreferenceSubmitDto preferenceSubmitDto) {
        UserEntity userEntity = preferenceSettingService.deletePreferenceByUser(preferenceSubmitDto);
        return ResponseEntity.ok(userEntity);
    }
}
