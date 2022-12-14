package com.challege.hunter.morse.services;

import com.challege.hunter.morse.exception.MorseException;

/**
 * Clase de tipo Interfaz con el contrato para los servicios Morse
 *
 * @author Carlos andres romero - soportecarlosromero@gmail.com
 * @version 1.0
 */
public interface IMorseService {

    // region Nivel 2
    /**
     * Nivel 2. Contrato del Metodo que convierte un mensaje de lenguaje Morse a Lenguaje Humano
     *
     * @param morseMessage
     * @return
     * @throws MorseException
     */
    String translate2Human(String morseMessage) throws MorseException ;

    /**
     * Nivel 2. Contrato del Metodo que convierte un mensaje de lenguaje Lenguaje Humano a Morse
     *
     * @param humanMessage
     * @return
     * @throws MorseException
     */
    String translate2Morse(String humanMessage) throws MorseException;
    // endregion

}
