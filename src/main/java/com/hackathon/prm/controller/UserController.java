package com.hackathon.prm.controller;

import com.hackathon.prm.dtos.UserDetails;
import com.hackathon.prm.services.UserServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/v1/prm/login")
public class UserController {

    @Autowired
    private UserServices userServices;

    @PostMapping
    public ResponseEntity<?> login(@RequestBody UserDetails userDetails) {
        log.info("User {} attempted login at {}", userDetails.getUserId(), userDetails.getTimestamp());
        return userServices.validateLogin(userDetails);
    }
}
