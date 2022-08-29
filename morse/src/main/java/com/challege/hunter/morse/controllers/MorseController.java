package com.challege.hunter.morse.controllers;

import com.challege.hunter.morse.exception.MorseException;
import com.challege.hunter.morse.domain.dto.MessageDto;
import com.challege.hunter.morse.services.IMorseService;
import com.challege.hunter.morse.utilscustom.Logs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/v1/morse")
@RestController
public class MorseController {

    // region Servicios
    private final IMorseService morseService;
    // endregion

    // region Inicializacion e inyeccion de dependencias en el Constructor
    @Autowired
    public MorseController(IMorseService morseService) {
        this.morseService = morseService;
    }
    // endregion

    // region Servicio de prueba: Healt
    /**
     * Servicio para comprobar que el servicio esta ejecutandose
     * @return
     */
    @GetMapping("/healt")
    public ResponseEntity<String> health(){
        Logs.info("Inicio del servicio: morse.health()" );
        String entity = "morse - ok running";
        Logs.info("Finaliza OK. del servicio: morse.health()" );
        return new ResponseEntity<>(entity, HttpStatus.OK);
    }
    // endregion

    // region Nivel 2

    /**
     * Metodo endpoint que convierte un mensaje de lenguaje Morse a Lenguaje Humano
     *
     * @param morseMessage
     * @return
     * @throws MorseException
     */
    @GetMapping("/decode-level2-traslate2human")
    public ResponseEntity<String> decodeTraslate2human(@RequestBody MessageDto morseMessage ) throws MorseException {
        Logs.info("Inicio del servicio: decode-level2-traslate2human" );

        String decodeMessage = morseService.translate2Human( morseMessage.getMessage());

        Logs.info("Finaliza OK. del servicio: decode-level2-traslate2human()" );
        return new ResponseEntity<>(decodeMessage, HttpStatus.OK);
    }


    /**
     * Metodo endpoint que convierte un mensaje de lenguaje Lenguaje Humano a Morse
     *
     * @param humanMessage
     * @return
     * @throws MorseException
     */
    @GetMapping("/decode-level2-traslate2morse")
    public ResponseEntity<String> decodeTraslate2morse(@RequestBody MessageDto humanMessage ) throws MorseException {
        Logs.info("Inicio del servicio: morse.decode-level2-traslate2morse" );

        String decodeMessage = morseService.translate2Morse( humanMessage.getMessage());

        Logs.info("Finaliza OK. del servicio: morse.decode-level2-traslate2morse" );
        return new ResponseEntity<>(decodeMessage, HttpStatus.OK);
    }

    // endregion


}
