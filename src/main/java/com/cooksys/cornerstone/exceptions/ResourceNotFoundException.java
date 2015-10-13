package com.cooksys.cornerstone.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Generates an HTTP 404 - Resource Not Found response when thrown in the Spring
 * MVC context.
 * 
 * @author timd
 *
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

}