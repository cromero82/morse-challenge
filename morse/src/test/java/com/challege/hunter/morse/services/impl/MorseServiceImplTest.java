package com.challege.hunter.morse.services.impl;

import com.challege.hunter.morse.exception.MorseException;
import com.challege.hunter.morse.utilscustom.MorseConstants;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Clase de tipo PruebaUntiaria de la clase de la implementaci�n del servicio Morse
 *
 * @author Carlos andres romero - soportecarlosromero@gmail.com
 * @version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
class MorseServiceImplTest {
    MorseServiceImpl morseService;

    @BeforeEach
    void setUp(){
        morseService = new MorseServiceImpl();
    }

    @Test
    void translate2Human() throws MorseException {
        String level2MessageMorseHumanInput = MorseConstants.Pruebas.LEVEL_2_MESSAGE_MORSE_HUMAN_INPUT;
        String level2MessageMorseHumanExpected = MorseConstants.Pruebas.LEVEL_2_MESSAGE_MORSE_HUMAN_EXPECTED;

        String resultService = morseService.translate2Human(level2MessageMorseHumanInput);

        Assertions.assertEquals(resultService, level2MessageMorseHumanExpected );
    }

    @Test
    void translate2Morse() throws MorseException {

        String level2MessageHumanMorseInput = MorseConstants.Pruebas.LEVEL_2_MESSAGE_HUMAN_MORSE_INPUT;
        String level2MessageHumanMorseExpected = MorseConstants.Pruebas.LEVEL_2_MESSAGE_HUMAN_MORSE_EXPECTED;

        String resultService = morseService.translate2Morse(level2MessageHumanMorseInput);

        Assertions.assertEquals(resultService, level2MessageHumanMorseExpected );
    }
}