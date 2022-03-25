package co.edu.escuelaing.ieti.usuario.exception;

import org.springframework.http.HttpStatus;

import javax.ws.rs.InternalServerErrorException;

public class InvalidCredentialsException extends InternalServerErrorException {

    public InvalidCredentialsException(){
        super();
    }
}
