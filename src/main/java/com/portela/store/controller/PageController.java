package com.portela.store.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/administrativo")
    public String acessarPaginaPrincipal(){
        return "administrativo/home";
    }
}
