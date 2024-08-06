package com.codeSumit.ServiceBookingSystem.service.authentication;

import org.springframework.stereotype.Service;

import com.codeSumit.ServiceBookingSystem.dto.SignupRequestDto;
import com.codeSumit.ServiceBookingSystem.dto.UserDto;

public interface AuthService {

    UserDto signupClient(SignupRequestDto signupRequestDto);

    Boolean presentByEmail(String email);

    UserDto signupCompany(SignupRequestDto signupRequestDto);

}
