package com.somon.ticket_management.common.response;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class ValidationErrorUtil {
    public static Map<String, Object> formatErrors(BindingResult bindingResult) {
        List<Map<String, String>> errors = new ArrayList<>();
        for (FieldError error : bindingResult.getFieldErrors()) {
            Map<String, String> field = Map.of(
                    "Field", error.getField(),
                    "message", Objects.requireNonNull(error.getDefaultMessage())
            );
            errors.add(field);
        }
        return Map.of("errors", errors);
    }
}
