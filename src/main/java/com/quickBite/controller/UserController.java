package com.quickBite.controller;

import com.quickBite.dtos.ApiResponse;
import com.quickBite.dtos.requests.RegisterUserRequest;
import com.quickBite.producer.UserServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserServices userServices;

    public UserController(UserServices userServices) {
        this.userServices = userServices;
    }
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterUserRequest request){
        try {
            return new ResponseEntity<>(new ApiResponse(userServices.registerUser(request),true), HttpStatus.OK);
        }catch (RuntimeException ex){
            return new ResponseEntity<>(new ApiResponse(ex.getMessage(),false),HttpStatus.BAD_REQUEST);
        }
    }
}
