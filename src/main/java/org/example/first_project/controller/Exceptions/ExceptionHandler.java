package org.example.first_project.controller.Exceptions;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(BindException.class)
    public Map<String, Object> handleBindException(BindException e) {
        List<String> errorList = e.getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).toList();
        Map<String, Object> error = new HashMap();
        error.put("Error", errorList);
        return error;
    }
}
