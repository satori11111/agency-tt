package com.amazonagency.service;


import com.amazonagency.dto.user.UserRegistrationRequestDto;
import com.amazonagency.dto.user.UserResponseDto;
import com.amazonagency.exception.RegistrationException;
import com.amazonagency.model.User;

public interface UserService {
    UserResponseDto register(UserRegistrationRequestDto request) throws RegistrationException;

    User getAuthenticatedUser();
}
