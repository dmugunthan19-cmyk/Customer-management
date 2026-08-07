package com.Customer.and.Order.Management.REST.API.dto;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public class ApiResponse {

    public static ResponseEntity<?> success(String message) {
        return ResponseEntity.ok(Map.of("message", message, "status code", HttpStatus.OK.value(), "success", true));
    }

    public static ResponseEntity<?> success(String message, int statusCode) {
        return ResponseEntity.ok(Map.of("message", message, "status code", statusCode, "success", true));
    }

    public static ResponseEntity<?> success(String message, int statusCode, Object data) {
        return ResponseEntity.ok(Map.of("message", message, "status code", statusCode, "success", true, "data", data));
    }

    public static ResponseEntity<?> created(String message, Object data) {
        return success(message, HttpStatus.CREATED.value(), data);
    }

    public static ResponseEntity<?> badRequest(String message) {
        return error(message, HttpStatus.BAD_REQUEST.value());
    }

    public static ResponseEntity<?> notFound(String message) {
        return error(message, HttpStatus.NOT_FOUND.value());
    }

    public static ResponseEntity<?> conflict(String message) {
        return error(message, HttpStatus.CONFLICT.value());
    }

    public static ResponseEntity<?> error(String message, int statusCode) {
        return ResponseEntity.ok(Map.of("message", message, "status code", statusCode, "success", false));
    }

    public static ResponseEntity<?> error(String message, int statusCode, Object errors) {
        return ResponseEntity.ok(Map.of("message", message, "status code", statusCode, "success", false, "errors", errors));
    }

    public static ResponseEntity<?> error(String message) {
        return ResponseEntity.ok(Map.of("message", message, "status code", HttpStatus.INTERNAL_SERVER_ERROR.value(), "success", false));
    }
}
