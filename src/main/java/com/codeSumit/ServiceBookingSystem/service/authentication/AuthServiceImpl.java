package com.codeSumit.ServiceBookingSystem.service.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codeSumit.ServiceBookingSystem.dto.SignupRequestDto;
import com.codeSumit.ServiceBookingSystem.dto.UserDto;
import com.codeSumit.ServiceBookingSystem.entity.User;
import com.codeSumit.ServiceBookingSystem.entity.enums.UserRole;
import com.codeSumit.ServiceBookingSystem.repository.UserRepository;
@Service
public class AuthServiceImpl implements AuthService
{

    @Autowired
    private UserRepository userRepository;

    public UserDto signupClient(SignupRequestDto signupRequestDto){

        User user=new User();
        user.setName(signupRequestDto.getName());
        user.setLastname(signupRequestDto.getLastname());
        user.setEmail(signupRequestDto.getEmail());
        user.setPhone(signupRequestDto.getPhone());
        user.setPassword(signupRequestDto.getPassword());

        user.setRole(UserRole.CLIENT);

        return userRepository.save(user).getDto();

    }

    public Boolean presentByEmail(String email){
        return userRepository.findFirstByEmail(email) !=null;
    }


    
    public UserDto signupCompany(SignupRequestDto signupRequestDto){

        User user=new User();
        user.setName(signupRequestDto.getName());
        user.setEmail(signupRequestDto.getEmail());
        user.setPhone(signupRequestDto.getPhone());
        user.setPassword(signupRequestDto.getPassword());

        user.setRole(UserRole.COMPANY);

        return userRepository.save(user).getDto();

    }
}
