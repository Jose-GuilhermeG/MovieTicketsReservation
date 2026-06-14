package io.github.CineTickets.core;

import io.github.CineTickets.core.Erros.DetailErroReponse;
import io.github.CineTickets.exceptions.NotExistsException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(NotExistsException.class)
    public ResponseEntity<DetailErroReponse> resourceNotExists(NotExistsException e , HttpServletRequest request){
        HttpStatus status = HttpStatus.NOT_FOUND;
        DetailErroReponse body = new DetailErroReponse(e.getMessage());
        return ResponseEntity.status(status).body(body);
    }
}
