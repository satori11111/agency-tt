package com.amazonagency.controller;

import com.amazonagency.dto.user.UserLoginRequestDto;
import com.amazonagency.dto.user.UserLoginResponseDto;
import com.amazonagency.dto.user.UserRegistrationRequestDto;
import com.amazonagency.dto.user.UserResponseDto;
import com.amazonagency.exception.RegistrationException;
import com.amazonagency.service.AuthenticationService;
import com.amazonagency.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "User authentication",description = "Endpoints for managing users")
@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    private final UserService userService;
    private final AuthenticationService authenticationService;

    @PostMapping("/login")
    @Operation(summary = "login registered user",description = "login registered user")
    public UserLoginResponseDto login(@RequestBody @Valid UserLoginRequestDto request) {

        return authenticationService.authenticate(request);
    }

    @PostMapping("/register")
    @Operation(summary = "register user",description = "register user")
    public UserResponseDto register(@RequestBody @Valid UserRegistrationRequestDto request)
            throws RegistrationException {
        System.out.println(request);
        return userService.register(request);
    }
}
