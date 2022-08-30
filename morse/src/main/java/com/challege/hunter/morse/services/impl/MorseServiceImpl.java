package com.challege.hunter.morse.services.impl;

import com.challege.hunter.morse.exception.MorseException;
import com.challege.hunter.morse.domain.models.MorseModel;
import com.challege.hunter.morse.services.IMorseService;
import com.challege.hunter.morse.utilscustom.DataUtilsMorse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.challege.hunter.morse.utilscustom.MorseConstants.TARGET_TO_HUMAN;
import static com.challege.hunter.morse.utilscustom.MorseConstants.TARGET_TO_MORSE;

/**
 * Clase que  implementa el servicio Morse
 *
 * @author Carlos andres romero - soportecarlosromero@gmail.com
 * @version 1.0
 * @see "https://es.wikipedia.org/wiki/C%C3%B3digo_morse"
 */
@Service
public class MorseServiceImpl implements IMorseService {

    // region Nivel 2

    /**
     * Implementacion del Metodo que convierte un mensaje de lenguaje Morse a Lenguaje Humano
     *
     * @param morseMessage
     * @return
     * @throws MorseException
     */
    @Override
    public String translate2Human(String morseMessage) throws MorseException {
        return translateLevel2(morseMessage, TARGET_TO_HUMAN);
    }

    /**
     * Implementacion del Metodo que convierte un mensaje de lenguaje Lenguaje Humano a Morse
     *
     * @param humanMessage
     * @return
     * @throws MorseException
     */
    @Override
    public String translate2Morse(String humanMessage) throws MorseException {
        return translateLevel2(humanMessage, TARGET_TO_MORSE);
    }

    // endregion


    // region funciones privadas de apoyo

    /**
     * Nivel 2. Convertidor de nivel 2
     *
     * @param MenssageCode
     * @return
     * @throws MorseException
     */
    private String translateLevel2(String MenssageCode, String targetConverter) throws MorseException {
        String[] itemsMessage = MenssageCode.split(" ");
        StringBuffer NatureMessage = new StringBuffer();

        for(int i = 0; i< itemsMessage.length; i++){
            String ActualItem = itemsMessage[i];
            Optional<MorseModel> elementoCodificado = DataUtilsMorse.getCharacter(ActualItem, targetConverter);
            String decodeItem = obtenerCaracterCodificado(elementoCodificado, ActualItem, targetConverter);

            if( ! decodeItem.equals("Fullstop") ){
                NatureMessage.append(decodeItem).append(" ");
            }else{
                NatureMessage.append(" ");
            }
        }

        String result = NatureMessage.toString();
        return result.substring( 0, result.length()-1 );
    }

    /**
     * Funcion que optiene caracter codificado en lenguaje humano
     *
     * @param elementoCodificado
     * @param caracter
     * @param targetConverter
     * @return
     * @throws MorseException En caso de no existir un elemento, se lanza esta excepcion marcada como 507
     */
    private String obtenerCaracterCodificado(Optional<MorseModel> elementoCodificado, String caracter, String targetConverter) throws MorseException {
        if(! elementoCodificado.isPresent() ){
            throw new MorseException(HttpStatus.INSUFFICIENT_STORAGE, String.format("El código: %s No se reconoce como un código Morse", caracter ) );
        }else{
            if( targetConverter.equals(TARGET_TO_HUMAN)){
                return elementoCodificado.get().getWord();
            }else{
                return elementoCodificado.get().getCode();
            }

        }
    }

    // endregion


}
