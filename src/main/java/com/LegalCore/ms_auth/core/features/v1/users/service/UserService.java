package com.LegalCore.ms_auth.core.features.v1.users.service;

import com.LegalCore.ms_auth.core.base.BaseService;
import com.LegalCore.ms_auth.core.features.v1.users.dto.UserRequestDTO;
import com.LegalCore.ms_auth.core.features.v1.users.dto.UserResponseDTO;
import com.LegalCore.ms_auth.core.features.v1.users.entity.UserEntity;
import com.LegalCore.ms_auth.core.features.v1.users.mapper.UserMapper;
import com.LegalCore.ms_auth.core.features.v1.users.repository.UserRepository;
import com.LegalCore.ms_auth.shared.exceptions.GenericEntityNotFoundException;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService implements BaseService<UserRequestDTO, UserResponseDTO> {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserResponseDTO create(UserRequestDTO request) {
        UserEntity entity = userMapper.toEntity(request);
        entity = userRepository.save(entity);
        return userMapper.toResponse(entity);
    }

    @Override
    public Page<UserResponseDTO> getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<UserEntity> result = userRepository.findAllByActiveTrue(pageable);
        return result.map(userMapper::toResponse);
    }

    @Override
    public UserResponseDTO getById(UUID id) {
        UserEntity entity = userRepository.findById(id)
                .orElseThrow(() -> new GenericEntityNotFoundException("User", id));
        return userMapper.toResponse(entity);
    }

    @Override
    public UserResponseDTO update(UUID id, UserRequestDTO request) {
        UserEntity entity = userRepository.findById(id)
                .orElseThrow(() -> new GenericEntityNotFoundException("User", id));

        userMapper.updateEntityFromDTO(request, entity);
        entity = userRepository.save(entity);
        return userMapper.toResponse(entity);
    }

    @Override
    public void delete(UUID id) {
        UserEntity entity = userRepository.findById(id)
                .orElseThrow(() -> new GenericEntityNotFoundException("User", id));
        entity.setActive(false);
        userRepository.save(entity);
    }

    @Override
    public UserResponseDTO restore(UUID id) {
        UserEntity entity = userRepository.findById(id)
                .orElseThrow(() -> new GenericEntityNotFoundException("User", id));
        entity.setActive(true);
        userRepository.save(entity);
        return userMapper.toResponse(entity);
    }
}
