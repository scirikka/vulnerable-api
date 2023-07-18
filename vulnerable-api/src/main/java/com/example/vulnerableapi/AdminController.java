package com.example.vulnerableapi;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/admin")
public class AdminController {
    //    API5:2023 Broken Function Level Authorization
    @GetMapping
    ResponseEntity<String> home() {
        return ResponseEntity.ok("Super secret admin portal");
    }
}
