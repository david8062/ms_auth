package com.LegalCore.ms_auth.core.features.v1.users.repository;

import com.LegalCore.ms_auth.core.base.BaseRepository;
import com.LegalCore.ms_auth.core.features.v1.users.entity.UserEntity;

import java.util.UUID;

public interface UserRepository extends BaseRepository <UserEntity, UUID> {
}
