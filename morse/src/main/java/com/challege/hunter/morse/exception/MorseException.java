package com.challege.hunter.morse.exception;

import com.challege.hunter.morse.utilscustom.Logs;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Clase de tipo excepción. personaliza la excepción y tiene por defecto el status code: 412 PRECONDICION_FAILED (Reglas de negocio)
 *
 * @author Carlos andres romero - soportecarlosromero@gmail.com
 * @version 1.0
 */
@ResponseStatus(code = HttpStatus.PRECONDITION_FAILED)
public class MorseException extends Exception {

    @Getter
    @Setter
    final HttpStatus httpStatus;

    private static final long serialVersionUID = 1L;

    public MorseException(HttpStatus status, String... exceptionMessage) {
        super(messageInitialize(exceptionMessage));
        this.httpStatus = status;
    }

    /**
     * Funcion que inicialice cada uno de los mensajes de error y devuelve el valor concatenado
     * @param exceptionMessage
     * @return
     */
    private static String messageInitialize(String... exceptionMessage) {
        StringBuilder sbMessage = new StringBuilder();
        for (String data : exceptionMessage) {
            sbMessage.append(data);
        }
        Logs.error(sbMessage.toString());
        return sbMessage.toString();
    }
}
