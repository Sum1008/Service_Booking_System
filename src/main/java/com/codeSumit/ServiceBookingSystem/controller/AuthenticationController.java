package com.codeSumit.ServiceBookingSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.codeSumit.ServiceBookingSystem.dto.SignupRequestDto;
import com.codeSumit.ServiceBookingSystem.dto.UserDto;
import com.codeSumit.ServiceBookingSystem.service.authentication.AuthService;

@RestController
public class AuthenticationController {


    @Autowired
    private AuthService authService;

    @PostMapping("/client/sign-up")
    public ResponseEntity signupClient(@RequestBody SignupRequestDto signupRequestDto){

        if(authService.presentByEmail(signupRequestDto.getEmail())){
            return new ResponseEntity<>("Client already exixst with this email",HttpStatus.NOT_ACCEPTABLE);
        }
        UserDto createdUser=authService.signupClient(signupRequestDto);
        return new ResponseEntity<>(createdUser,HttpStatus.OK);

    }

    @PostMapping("/company/sign-up")
    public ResponseEntity signupCompany(@RequestBody SignupRequestDto signupRequestDto){

        if(authService.presentByEmail(signupRequestDto.getEmail())){
            return new ResponseEntity<>("Company already exixst with this email",HttpStatus.NOT_ACCEPTABLE);
        }
        UserDto createdUser=authService.signupCompany(signupRequestDto);
        return new ResponseEntity<>(createdUser,HttpStatus.OK);

    }
}
