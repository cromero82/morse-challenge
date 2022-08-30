package com.challege.hunter.morse.utilscustom;

import com.challege.hunter.morse.domain.models.MorseModel;

import java.util.Arrays;
import java.util.Optional;

import static com.challege.hunter.morse.utilscustom.MorseConstants.TARGET_TO_HUMAN;

/**
 * Clase de tipo Static Con metodos globales para acceder a definicion de Morse y metodos comunes del lenguaje Morse
 *
 * @author Carlos andres romero - soportecarlosromero@gmail.com
 * @version 1.0
 */
public class DataUtilsMorse {

    // region Inicializacion codificacion Morse
    private static MorseModel[] morseCodes = {
            new MorseModel("A",".-"),
            new MorseModel("B","-..."),
            new MorseModel("C","-.-."),
            new MorseModel("D","-.."),
            new MorseModel("E","."),
            new MorseModel("F","..-."),
            new MorseModel("G","--."),
            new MorseModel("H","...."),
            new MorseModel("I",".."),
            new MorseModel("J",".---"),
            new MorseModel("K","-.-"),
            new MorseModel("L",".-.."),
            new MorseModel("M","--"),
            new MorseModel("N","-."),
            new MorseModel("O","---"),
            new MorseModel("P",".--."),
            new MorseModel("Q","--.-"),
            new MorseModel("R",".-."),
            new MorseModel("S","..."),
            new MorseModel("T","-"),
            new MorseModel("U","..-"),
            new MorseModel("V","...-"),
            new MorseModel("W",".--"),
            new MorseModel("X","-..-"),
            new MorseModel("Y","-.--"),
            new MorseModel("Z","--.."),
            new MorseModel("0","-----"),
            new MorseModel("1",".----"),
            new MorseModel("2","..---"),
            new MorseModel("3","...--"),
            new MorseModel("4","....-"),
            new MorseModel("5","....."),
            new MorseModel("6","-...."),
            new MorseModel("7","--..."),
            new MorseModel("8","---.."),
            new MorseModel("9","----."),
            new MorseModel("10","----."),
            new MorseModel("Fullstop",".-.-.-"),
    };
    // endregion


    private DataUtilsMorse(){
        // Inicializacion requerida por sonar
    }

    /**
     * Funcion que devuelve un objeto codificado de tipo MorseModel consultando por codigo Morse
     *
     * @param code       Codigo morse en formato String
     * @param targetConverter
     * @return
     */
    public static Optional<MorseModel> getCharacter(String code, String targetConverter){
        if( targetConverter.equals(TARGET_TO_HUMAN)){
            return Arrays.stream(morseCodes).filter(f -> f.getCode().equals(code)).findFirst();
        }else{
            return Arrays.stream(morseCodes).filter(f -> f.getWord().equals(code)).findFirst();
        }

    }
}
