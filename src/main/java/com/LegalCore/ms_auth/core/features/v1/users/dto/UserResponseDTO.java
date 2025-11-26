package com.LegalCore.ms_auth.core.features.v1.users.dto;

import com.LegalCore.ms_auth.core.base.BaseDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponseDTO extends BaseDTO {
    private String firstName;
    private String secondName;
    private String lastName;
    private String secondLastName;
    private String country;
    private String city;
    private String address;
    private String phone;
    private String email;
    private String username;
    private String documentType;
    private String documentNumber;
    private Boolean twoFa;
    private String userType;
    private String tenantId;
    private String status;
}
