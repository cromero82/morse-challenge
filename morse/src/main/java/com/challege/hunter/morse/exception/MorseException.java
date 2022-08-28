package com.challege.hunter.morse.exception;

import com.challege.hunter.morse.utilscustom.Logs;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Clase de tipo excepción. personaliza la excepción y tiene por defecto el status code: 412 PRECONDICION_FAILED (Reglas de negocio)
 * @author Carlos Andres Romero
 */
@ResponseStatus(code = HttpStatus.PRECONDITION_FAILED)
public class MorseException extends Exception {

    @Getter
    @Setter
    final HttpStatus httpStatus;

    private static final long serialVersionUID = 1L;

    public MorseException(String... exceptionMsg) {
        super(llenarMensaje(exceptionMsg));
        this.httpStatus = HttpStatus.PRECONDITION_FAILED;
    }

    public MorseException(HttpStatus status, String... exceptionMsg) {
        super(llenarMensaje(exceptionMsg));
        this.httpStatus = status;
    }

    private static String llenarMensaje(String... exceptionMsg) {
        StringBuilder sbMensaje = new StringBuilder();
        for (String data : exceptionMsg) {
            sbMensaje.append(data);
        }
        Logs.error(sbMensaje.toString());
        return sbMensaje.toString();
    }
}
