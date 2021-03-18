package com.fatec.compras.endpoint.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/status")
public class StatusController {

    @GetMapping
    public String status(){
        return "Status OK";
    }
}
