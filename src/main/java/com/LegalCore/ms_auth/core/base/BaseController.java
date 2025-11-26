package com.LegalCore.ms_auth.core.base;

import com.LegalCore.ms_auth.shared.responses.ResponseUtil;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

public abstract class BaseController<
        RQ,  // Request DTO
        RS,  // Response DTO
        S extends BaseService<RQ, RS> // Servicio genérico
        > {

    protected final S service;

    protected BaseController(S service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<?> getAll(@RequestParam(defaultValue = "0") int page,
                                    @RequestParam(defaultValue = "10") int size) {
        Page<RS> response = service.getAll(page, size);
        return ResponseUtil.paged(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable UUID id) {
        RS response = service.getById(id);
        return ResponseUtil.ok(response);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody RQ request) {
        RS response = service.create(request);
        return ResponseUtil.created(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable UUID id, @RequestBody RQ request) {
        RS response = service.update(id, request);
        return ResponseUtil.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        service.delete(id);
        return ResponseUtil.noContent();
    }

    @PatchMapping("/{id}/restore")
    public ResponseEntity<?> restore(@PathVariable UUID id) {
        RS response = service.restore(id);
        return ResponseUtil.ok(response);
    }
}
