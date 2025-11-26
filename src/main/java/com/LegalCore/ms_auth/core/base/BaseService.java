package com.LegalCore.ms_auth.core.base;

import org.springframework.data.domain.Page;

import java.util.UUID;

public interface BaseService<
        RQ,  // Request DTO
        RS   // Response DTO
        > {

    RS create(RQ request);

    Page<RS> getAll(int page, int size);

    RS getById(UUID id);

    RS update(UUID id, RQ request);

    void delete(UUID id);

    RS restore(UUID id);
}
