package assignment1.config.exceptions;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<Object> handleExceptions(Exception ex) {
        ExceptionConfig exceptionConfig = new ExceptionConfig(BAD_REQUEST);
        exceptionConfig.setMessage(ex.getMessage());
        return buildResponseEntity(exceptionConfig);
    }

    private ResponseEntity<Object> buildResponseEntity(ExceptionConfig exceptionConfig) {
        return new ResponseEntity<>(exceptionConfig, exceptionConfig.getStatus());
    }
}