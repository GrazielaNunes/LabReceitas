package br.senai.service;


import br.senai.model.Categoria;
import br.senai.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatergoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;


    public Categoria salvar(Categoria categoria) {
        Categoria cat = categoriaRepository.save(categoria);
        return cat;
    }

    public List<Categoria> getCategorias() {
        return categoriaRepository.findAll();
    }

    public void deletar(Long id) {
        categoriaRepository.deleteById(id);
    }
}
