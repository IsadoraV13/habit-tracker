package com.isadora.habittracker.domain;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/*
This is a generic handler - and can be optimised later
 */
@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "This entity does not exist")
public class EntityNotFound extends RuntimeException{
}
