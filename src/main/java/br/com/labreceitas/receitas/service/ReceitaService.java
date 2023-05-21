package br.com.labreceitas.receitas.service;

import br.com.labreceitas.receitas.model.Receita;
import br.com.labreceitas.receitas.repository.ReceitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReceitaService {

    @Autowired
    private ReceitaRepository receitaRepository;

    public Receita salvar(Receita receita) {
        Receita r = receitaRepository.save(receita);
        return r;
    }

    public List<Receita> listarTodos() {
        List<Receita> receitas = receitaRepository.findAll();
        return receitas;
    }

    public void deletar(Long id) {
        receitaRepository.deleteById(id);
    }

    public List<Receita> listarPorCategoria(Long idCategoria) {
        return receitaRepository.findByCategoriaId(idCategoria);
    }
}
