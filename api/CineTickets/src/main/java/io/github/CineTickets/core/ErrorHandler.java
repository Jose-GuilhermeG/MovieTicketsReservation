package io.github.CineTickets.core;

import io.github.CineTickets.core.Erros.DetailErroReponse;
import io.github.CineTickets.core.Erros.ErroResponse;
import io.github.CineTickets.core.Erros.FieldErr;
import io.github.CineTickets.exceptions.AlreadyExistsException;
import io.github.CineTickets.exceptions.NotExistsException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(NotExistsException.class)
    public ResponseEntity<DetailErroReponse> resourceNotExists(NotExistsException e , HttpServletRequest request){
        HttpStatus status = HttpStatus.NOT_FOUND;
        DetailErroReponse body = new DetailErroReponse(e.getMessage());
        return ResponseEntity.status(status).body(body);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErroResponse resourceMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        List<FieldErr> erros = e.getFieldErrors().stream().map(erro -> new FieldErr(erro.getField(), erro.getDefaultMessage())).toList();
        return new ErroResponse(HttpStatus.BAD_REQUEST.value(), erros);
    }

    @ExceptionHandler(AlreadyExistsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<DetailErroReponse> resourceAlreadyExistsException(AlreadyExistsException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new DetailErroReponse(e.getMessage()));
    }

}
