package com.example.vulnerableapi;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@RestController
@RequestMapping("/beta/users")
public class BetaUserController {

    @PersistenceContext
    private EntityManager entityManager;

    //    API9:2023 Improper Inventory Management
    @GetMapping(value = "/{id}")
    ResponseEntity<String> getUser(@PathVariable String id) {
        id = id.trim();
        String query = "SELECT * FROM users WHERE id =" + id;
        try {
            List<Object[]> resultList = entityManager.createNativeQuery(query).getResultList();
            List<User> users = new ArrayList<>();

            for (Object[] result : resultList) {
                User user = new User();
                user.setId((Long) result[3]);
                user.setName((String) result[5]);
                user.setEmail((String) result[4]);
                user.setBalance((Long) result[1]);
                user.setCvc((Long) result[2]);
                user.setIsAdmin((Boolean) result[0]);
                users.add(user);
            }
            return ResponseEntity.ok(users.toString());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error executing query");
        }
    }
}
