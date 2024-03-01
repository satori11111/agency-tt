package com.amazonagency.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginRequestDto {
    @NotNull
    @Email
    private String email;
    @Length(min = 4,max = 255)
    private String password;
}
