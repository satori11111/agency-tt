package com.amazonagency.service.impl;

import com.amazonagency.dto.user.UserRegistrationRequestDto;
import com.amazonagency.dto.user.UserResponseDto;
import com.amazonagency.exception.EntityNotFoundException;
import com.amazonagency.exception.RegistrationException;
import com.amazonagency.model.User;
import com.amazonagency.repository.UserRepository;
import com.amazonagency.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public UserResponseDto register(UserRegistrationRequestDto request)
            throws RegistrationException {
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new RegistrationException("User with email: "
                    + request.getEmail() + " already registered");
        }
        User user = new User();
        user.setPassword(request.getPassword());
        user.setEmail(request.getEmail());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User savedUser = userRepository.save(user);
        return new UserResponseDto(savedUser.getId(),savedUser.getFirstName(), savedUser.getLastName());
    }

    @Override
    public User getAuthenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return userRepository.findByEmail(authentication.getName())
                .orElseThrow(() -> new EntityNotFoundException(
                        "Can't find user with email " + authentication.getName()));
    }
}
