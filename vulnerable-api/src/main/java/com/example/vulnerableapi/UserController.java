package com.example.vulnerableapi;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/users")
public class UserController {

    final private UserRepository userRepository;

    public UserController(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //API1:2023 - Broken Object Level Authorization
    @GetMapping(value = "/{id}")
    ResponseEntity<User> getUser(@PathVariable final Long id) {
        var user = userRepository.findById(id).orElseThrow(() -> new RuntimeException(String.format("User with id %s not found", id)));
        return ResponseEntity.ok(user);
    }

    //API3:2023 - Broken Object Property Level Authorization
    @PutMapping(value = "/{id}")
    ResponseEntity<User> updateUser(@PathVariable Long id,
                                    @RequestBody User newUser) {
        return ResponseEntity.ok(userRepository.save(newUser));
    }

    @GetMapping()
    ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok(userRepository.findAll());
    }

    //    API8:2023 Security Misconfiguration
    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<String> handleException(RuntimeException e) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        e.printStackTrace(pw);
        String sStackTrace = sw.toString();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Something went wrong, here exception: " + sStackTrace);
    }


}
