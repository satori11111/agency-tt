package com.amazonagency.service;


import com.amazonagency.dto.user.UserLoginRequestDto;
import com.amazonagency.dto.user.UserLoginResponseDto;

public interface AuthenticationService {
    public UserLoginResponseDto authenticate(UserLoginRequestDto requestDto);
}
