package com.trucare.auth_service.controller;


import com.trucare.auth_service.entity.UserCredential;
import com.trucare.auth_service.service.AuthService;
import com.trucare.auth_service.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/addUser")
    public String addNewuser(@RequestBody UserCredential user){
        return authService.addUser(user);
    }

    @GetMapping("/token")
    public String getToken(UserCredential userCredential){
        return authService.generateToken(userCredential.getName());
    }

    @GetMapping("/validateToken")
    public String validateToken(@RequestParam("token") String token){
        authService.validateToken(token);

        return "token is valid";
    }
}
