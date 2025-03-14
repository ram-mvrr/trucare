package com.trucare.auth_service.service;

import com.trucare.auth_service.entity.UserCredential;
import com.trucare.auth_service.respository.UserCredentialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserCredentialRepository userCredentialRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    public String addUser(UserCredential userCredential){
        userCredentialRepository.save(userCredential);
        userCredential.setPassword(passwordEncoder.encode(userCredential.getPassword()));
        return "created user";
    }

    public String generateToken(String username){
        return jwtService.createToken(username);
    }

    public void validateToken(String token){
        jwtService.validateToken(token);
    }


}
