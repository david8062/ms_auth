package com.LegalCore.ms_auth.shared.exceptions;

import jakarta.persistence.EntityNotFoundException;

public class GenericEntityNotFoundException extends RuntimeException {
    public GenericEntityNotFoundException(String entityName, Object id) {
        super(entityName + " with id " + id + " not found");
    }
}
