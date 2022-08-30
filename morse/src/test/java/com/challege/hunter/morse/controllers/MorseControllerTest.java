package com.challege.hunter.morse.controllers;

import com.challege.hunter.morse.utilscustom.MorseConstants;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.io.File;
import java.nio.file.Files;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Clase de tipo PruebaUntiaria del Controlador del servicio Morse
 *
 * @author Carlos andres romero - soportecarlosromero@gmail.com
 * @version 1.0
 */
@SpringBootTest
@AutoConfigureMockMvc
class MorseControllerTest {
    public static final String BASE_ROUTE = "/v1/morse/";
    @Autowired
    private MockMvc mockMvc;

    @Test
    void health() {
    }

    @Test
    void decodeTraslate2human() throws Exception {

        //Given: mensaje en lenguaje morse
        File resource = new ClassPathResource("jsons/morse-message.json").getFile();
        String jsonStringDataInput = new String(Files.readAllBytes(resource.toPath()));

        //When: ejecuto el servicio para convertir de morse a humano
        ResultActions perform = this.mockMvc.perform(get(BASE_ROUTE +
                "2text" )
                .content(jsonStringDataInput)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON));

        //Then: Entonces obtengo una respuesta satisfactoria, con el mensaje convertido a humano
        String level2MessageMorseHumanExpected = MorseConstants.Pruebas.LEVEL_2_MESSAGE_MORSE_HUMAN_EXPECTED;
        perform.andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value(level2MessageMorseHumanExpected));
    }

    @Test
    void decodeTraslate2morse() throws Exception {

        //Given: mensaje en lenguaje morse
        File resource = new ClassPathResource("jsons/nature-message.json").getFile();
        String jsonStringDataInput = new String(Files.readAllBytes(resource.toPath()));

        //When: ejecuto el servicio para convertir de humano a morse
        ResultActions perform = this.mockMvc.perform(get(BASE_ROUTE +
                "decodeBits" )
                .content(jsonStringDataInput)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON));

        //Then: Entonces obtengo una respuesta satisfactoria, con el mensaje convertido a morse
        String level2MessageHumanMorseExpected = MorseConstants.Pruebas.LEVEL_2_MESSAGE_HUMAN_MORSE_EXPECTED;
        perform.andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value(level2MessageHumanMorseExpected));

    }
}