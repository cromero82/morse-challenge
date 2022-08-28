package com.challege.hunter.morse.utilscustom;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Formatter;
import java.util.IllegalFormatException;

public class Logs {

    private Logs() {
        // Inicializacion requerida por Sonar
    }

    public static final Logger LOG = LoggerFactory.getLogger("filelogger");

    /**
     * Funcion encargada de imprimir en el log un mensaje de tipo: debug
     *
     * @param message
     */
    public static final void debug(String... message) {
        String formattedStr = concat(message);
        LOG.debug(formattedStr);
    }

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
     * Funcion encargada de imprimir en el log un mensaje de tipo: warn
     *
     * @param message
     */
    public static final void warn(String... message) {
        String formattedStr = concat(message);
        LOG.warn(formattedStr);
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
     * Funcion encargada de imprimir en el log un mensaje de tipo: error
     *
     * @param message
     * @param args
     */
    public static final void error(String message, Object... args) {
        String formattedStr = concat(message, args);
        LOG.error(formattedStr);
    }



    public static final void error(String msg, Throwable t) {
        LOG.error(msg, t);
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

    /**
     * Funcion que se encarga de concatenar varios elementos de caracteres
     *
     * @param string
     * @param args
     * @return
     */
    private static String concat(String string, Object... args) {
        String strOut = "";
        try (Formatter formatter = new Formatter()) {
            strOut = formatter.format(string, args).toString();
        } catch (IllegalFormatException e) {
            Logs.error("StringUtil: no fue posible concatenar la cadena según formato solicitado. >> {}", e.getMessage());
        }
        return strOut;
    }
}
