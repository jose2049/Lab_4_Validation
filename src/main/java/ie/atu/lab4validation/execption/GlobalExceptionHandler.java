package ie.atu.lab4validation.execption;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    //Handle validation errors globally
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> handleValidationExceptions(MethodArgumentNotValidException ex){
        Map<String, String> errors = new HashMap<>();
        for(FieldError fieldError : ex.getBindingResult().getFieldErrors()){
            String fieldName = fieldError.getField();
            String errorMessage = fieldError.getDefaultMessage();
            errors.put(fieldName,errorMessage);
        }
        return ResponseEntity.badRequest().body(errors);
    }
}
