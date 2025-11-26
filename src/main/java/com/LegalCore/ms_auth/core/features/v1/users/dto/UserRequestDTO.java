package com.LegalCore.ms_auth.core.features.v1.users.dto;

import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Getter
@Setter
public class UserRequestDTO {
    @NotBlank(message = "First name is required")
    @Size(max = 100, message = "First name must be at most 100 characters")
    private String firstName;

    @Size(max = 100, message = "Second name must be at most 100 characters")
    private String secondName;

    @NotBlank(message = "Last name is required")
    @Size(max = 100, message = "Last name must be at most 100 characters")
    private String lastName;

    @Size(max = 100, message = "Second last name must be at most 100 characters")
    private String secondLastName;

    @Size(max = 100, message = "Country must be at most 100 characters")
    private String country;

    @Size(max = 100, message = "City must be at most 100 characters")
    private String city;

    @Size(max = 200, message = "Address must be at most 200 characters")
    private String address;

    @Size(max = 50, message = "Phone must be at most 50 characters")
    private String phone;

    @NotBlank(message = "Email is required")
    @Email(message = "Email must be valid")
    @Size(max = 150, message = "Email must be at most 150 characters")
    private String email;

    @Size(max = 100, message = "Username must be at most 100 characters")
    private String username;

    @Size(max = 50, message = "Document type must be at most 50 characters")
    private String documentType;

    @Size(max = 100, message = "Document number must be at most 100 characters")
    private String documentNumber;

    @NotBlank(message = "Password is required")
    @Size(max = 255, message = "Password must be at most 255 characters")
    private String password;

    private Boolean twoFa;

    @Size(max = 100, message = "User type must be at most 100 characters")
    private String userType;

    @NotBlank(message = "Tenant ID is required")
    @Size(max = 100, message = "Tenant ID must be at most 100 characters")
    private String tenantId;

    private String status;
}
