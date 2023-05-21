package br.com.labreceitas.receitas.controllers;

import br.com.labreceitas.receitas.model.Receita;
import br.com.labreceitas.receitas.repository.ReceitaRepository;
import br.com.labreceitas.receitas.service.ReceitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/receitas") // localhost:8090/receitas
public class ReceitaController {

    @Autowired
    private ReceitaService receitaService;

    @Autowired
    private ReceitaRepository receitaRepository;

    @PostMapping
    public ResponseEntity<Receita> salvar(@RequestBody Receita receita){
        Receita r = receitaService.salvar(receita);
        return new ResponseEntity<>(r, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Receita>> listarTodos(){
        List<Receita> receitas = receitaService.listarTodos();
        return new ResponseEntity<>(receitas, HttpStatus.FOUND);
    }

    @DeleteMapping(value = "/{id}" )
    public ResponseEntity<String> deletarPorId(@PathVariable Long id) {
        receitaService.deletar(id);
        return new ResponseEntity<>("A receita de id: " + id + " foi deletada com sucesso!", HttpStatus.OK);
    }

    @PutMapping(value = "/{id}" )
    public ResponseEntity<Receita> atualizarPorId(@PathVariable Long id, @RequestBody Receita receita) {

        Optional<Receita> receitaData = receitaRepository.findById(id);
        if (receitaData.isPresent()) {
            Receita rec = receitaData.get();
            rec.setCategoria(receita.getCategoria());
            rec.setNome(receita.getNome());
            rec.setIngredientes(receita.getIngredientes());
            rec.setModoPreparo(receita.getModoPreparo());
            rec.setRestricao(receita.isRestricao());
            return new ResponseEntity<>(receitaRepository.save(rec), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/categoria/{id}" )
    public ResponseEntity<List<Receita>> listarPorCategoria(@PathVariable Long id) {
        List<Receita> receitas = receitaService.listarPorCategoria(id);
        return new ResponseEntity<>(receitas, HttpStatus.FOUND);
    }


}

