package kz.iitu.itse1902.var1_nurkhan.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class NotFoundException extends Exception {
    private static final long serialVersionUID = 1L;
    public NotFoundException(String message){
        super(message);
    }
}
