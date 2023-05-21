package br.com.labreceitas.receitas.controllers;

import br.com.labreceitas.receitas.service.ReceitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReceitaController {

    @Autowired
    private ReceitaService receitaService;


}
