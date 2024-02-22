package com.cubanfardo.cubanfardoreport.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HealthController {

    @GetMapping
    public Map<String, String> getStatus() {
        Map<String, String> map = new HashMap<>();
        map.put("status", "UP");
        return map;
    }
}
