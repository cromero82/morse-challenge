package com.challege.hunter.morse.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/v1/morse")
@RestController
public class MorseController {

    @GetMapping("/healt")
    public ResponseEntity<String> health(){
        String entity = "morse - ok running";
        return new ResponseEntity<>(entity, HttpStatus.OK);
    }
}
