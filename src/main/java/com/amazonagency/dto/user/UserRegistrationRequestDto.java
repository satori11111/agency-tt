package com.amazonagency.dto.user;

import com.amazonagency.validation.FieldMatch;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@FieldMatch(field = "password",
        fieldMatch = "repeatPassword",
        message = "Passwords do not match!")
@AllArgsConstructor
@NoArgsConstructor
public class UserRegistrationRequestDto {
    @NotNull
    @Length(min = 1,max = 255)
    private String firstName;
    @NotNull
    @Length(min = 1,max = 255)
    private String lastName;
    @NotNull
    @Email
    private String email;
    @Length(min = 4,max = 255)
    @NotNull
    private String password;
    @Length(min = 4,max = 255)
    @NotNull
    private String repeatPassword;
}
