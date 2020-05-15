package com.hackathon.prm.controller;

import com.hackathon.prm.dtos.DishDto;
import com.hackathon.prm.dtos.UserDetails;
import com.hackathon.prm.entities.DishEntity;
import com.hackathon.prm.services.DishService;
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
@RequestMapping("v1/prm/expandDish")
public class DishController {

    @Autowired private DishService dishService;

    @PostMapping
    public ResponseEntity<?> login(@RequestBody DishDto dishDto){
        return ResponseEntity.ok(dishService.getDish(dishDto));
    }
}
