package com.challege.hunter.morse.services;

import com.challege.hunter.morse.exception.MorseException;

public interface IMorseService {
    String translate2Human(String codigoMorse) throws MorseException;
}
