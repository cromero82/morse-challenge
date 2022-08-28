package com.challege.hunter.morse.services.impl;

import com.challege.hunter.morse.exception.MorseException;
import com.challege.hunter.morse.domain.models.MorseModel;
import com.challege.hunter.morse.services.IMorseService;
import com.challege.hunter.morse.utilscustom.DataUtilsMorse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MorseServiceImpl implements IMorseService {

    /**
     * Nivel 2. Metodo convierte un mensaje de lenguaje Morse a Lenguaje Humano
     *
     * @param mensajeCodificadoMorse
     * @return
     * @throws MorseException
     */
    @Override
    public String translate2Human(String mensajeCodificadoMorse) throws MorseException {
        String[] itemsMorseMensaje = mensajeCodificadoMorse.split(" ");
        StringBuffer mensajeNatural = new StringBuffer();
        StringBuffer palabra = new StringBuffer();

        for(int i = 0; i< itemsMorseMensaje.length; i++){
            String itemActualMorse = itemsMorseMensaje[i];
            Optional<MorseModel> elementoCodificado = DataUtilsMorse.getCharacter(itemActualMorse);
            String caracterDecodificado = obtenerCaracterCodificado(elementoCodificado, itemActualMorse);

            if( ! caracterDecodificado.equals("Fullstop") ){
                mensajeNatural.append(caracterDecodificado);
            }else{
                mensajeNatural.append(" ");
            }
        }

        return mensajeNatural.toString();
    }

    /**
     * Funcion que optiene caracter codificado en lenguaje humano
     * @param elementoCodificado
     * @param caracter
     * @return
     * @throws MorseException   En caso de no existir un elemento, se lanza esta excepcion marcada como 507
     */
    private String obtenerCaracterCodificado(Optional<MorseModel> elementoCodificado, String caracter) throws MorseException {
        if(! elementoCodificado.isPresent() ){
            throw new MorseException(HttpStatus.INSUFFICIENT_STORAGE, String.format("El código: %s No se reconoce como un código Morse", caracter ) );
        }else{
            return elementoCodificado.get().getCaracter();
        }
    }
}
