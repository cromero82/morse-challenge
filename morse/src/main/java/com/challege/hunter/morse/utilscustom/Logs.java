package com.challege.hunter.morse.utilscustom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Clase de tipo Static Con metodos generales para el manejo centralizado de Logs
 *
 * @author Carlos andres romero - soportecarlosromero@gmail.com
 * @version 1.0
 */
public class Logs {

    private Logs() {
        // Inicializacion requerida por Sonar
    }

    public static final Logger LOG = LoggerFactory.getLogger("filelogger");

    /**
     * Funcion encargada de imprimir en el log un mensaje de tipo: info
     *
     * @param message
     */
    public static final void info(String... message) {
        String formattedStr = concat(message);
        LOG.info(formattedStr);
    }

    /**
     * Funcion encargada de imprimir en el log un mensaje de tipo: error
     *
     * @param message
     */
    public static final void error(String... message) {
        String formattedStr = concat(message);
        LOG.error(formattedStr);
    }

    /**
     * Funcion que se encarga de concatenar varios elementos de caracteres
     *
     * @param strings
     * @return
     */
    private static String concat(String... strings) {
        String strOut = "";
        try {
            StringBuilder message = StringBuilder.class.newInstance();
            for (String strPart : strings) {
                message.append(strPart);
            }
            strOut = message.toString();
        } catch (InstantiationException | IllegalAccessException e) {
            Logs.error("concat: No ha sido posible concatenar las cadenas de texto. >> {}", e.getMessage());
        }
        return strOut;
    }
}
