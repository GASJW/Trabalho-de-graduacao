package com.fatec.compras.endpoint.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/statusTeste")
public class StatusTesteController {

    @GetMapping
    public String status(){
        return "Status OK - ";
    }
}
