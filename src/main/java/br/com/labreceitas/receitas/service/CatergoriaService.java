package br.com.labreceitas.receitas.service;

import br.com.labreceitas.receitas.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CatergoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;



}
