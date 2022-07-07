package example.archive.controllers;

import example.archive.utils.exceptions.*;
import example.archive.utils.exceptions.Error;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class ErrorsController {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Error notFoundErr(NotFoundException ex){
        return ErrorFactory.newError(ex);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.CONFLICT)
    public Error alreadyExistsErr(AlreadyExistsException ex){
        return ErrorFactory.newError(ex);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Error badRequestErr(ForClientException ex){
        return ErrorFactory.newError(ex);
    }
}
