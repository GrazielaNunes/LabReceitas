package br.senai.controllers;

import br.senai.model.Categoria;
import br.senai.service.CatergoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/categorias") // localhost:8090/categorias
public class CategoriaController {

    @Autowired
    private CatergoriaService categoriaService;

    @PostMapping
    public ResponseEntity<Categoria> salvar(@RequestBody Categoria categoria) {
        Categoria cat = categoriaService.salvar(categoria);
        return new ResponseEntity<>(cat, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Categoria>> listarTodasCategorias(){
        return new ResponseEntity<List<Categoria>>(categoriaService.getCategorias(), HttpStatus.FOUND);
    }

    @DeleteMapping(value = "/{id}" )
    public ResponseEntity<String> deletarPorId(@PathVariable Long id) {
        categoriaService.deletar(id);
        return new ResponseEntity<>("A categoria de id: " + id + " foi deletada com sucesso!", HttpStatus.OK);
    }
}
