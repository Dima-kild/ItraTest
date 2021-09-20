package com.example.ItraTest.controller;

import com.example.ItraTest.config.jwt.JwtProvider;
import com.example.ItraTest.entity.User;
import com.example.ItraTest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class AuthController {

    @Autowired
    private UserService userService;
    @Autowired
    private JwtProvider jwtProvider;

    @PostMapping("/register")
    public String registerUser(@RequestBody @Valid RegistrationRequest registrationRequest){
        User user = new User();
        user.setPassword(registrationRequest.getPassword());
        user.setEmail(registrationRequest.getEmail());
        userService.saveUser(user);
        return "registration complete";
    }

    @PostMapping("/auth")
    public AuthResponse authResponse(@RequestBody AuthRequest authRequest){
        User user = userService.findByEmailAndPassword(authRequest.getEmail(), authRequest.getPassword());
        String token = jwtProvider.generateToken(user.getEmail());
        return new AuthResponse(token);
    }
}
