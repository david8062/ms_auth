package com.LegalCore.ms_auth.core.features.v1.users.controller;

import com.LegalCore.ms_auth.core.base.BaseController;
import com.LegalCore.ms_auth.core.features.v1.users.dto.UserRequestDTO;
import com.LegalCore.ms_auth.core.features.v1.users.dto.UserResponseDTO;
import com.LegalCore.ms_auth.core.features.v1.users.service.UserService;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/v1/users")
public class UserController extends BaseController<UserRequestDTO, UserResponseDTO, UserService> {

    public UserController(UserService service) {
        super(service);
    }
}
