package br.com.fatec.chopperhousegames.inbound.controller.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseWithErrorAndFields> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        ResponseWithErrorAndFields responseWithErrorAndFields = new ResponseWithErrorAndFields("CMP-01", "Alguns campos estão vazios. Preencha-os e tente novamente", new HashMap<>());
        exception.getFieldErrors().forEach(fieldError -> responseWithErrorAndFields.getCampos().put(fieldError.getField(), fieldError.getDefaultMessage()));

        return ResponseEntity.badRequest().body(responseWithErrorAndFields);
    }
}
