package com.challege.hunter.morse.utilscustom;

/**
 * Clase de tipo Estatica para acceder globalmente a las constantes de la solucion
 *
 * @author Carlos andres romero - soportecarlosromero@gmail.com
 * @version 1.0
 */
public class MorseConstants {
    public static final String TARGET_TO_HUMAN = "Human";
    public static final String TARGET_TO_MORSE = "Morse";

    public class Pruebas {

        private Pruebas() {
            // Inicializacion requerida por Sonar
        }
        public static final String LEVEL_2_MESSAGE_MORSE_HUMAN_INPUT =".... --- .-.. .- -- . .-.. ..";
        public static final String LEVEL_2_MESSAGE_MORSE_HUMAN_EXPECTED ="H O L A M E L I";

        public static final String LEVEL_2_MESSAGE_HUMAN_MORSE_INPUT ="H O L A M E L I";
        public static final String LEVEL_2_MESSAGE_HUMAN_MORSE_EXPECTED =".... --- .-.. .- -- . .-.. ..";

    }
}
