package br.senai.service;

import br.senai.model.Receita;
import br.senai.repository.CategoriaRepository;
import br.senai.repository.ReceitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReceitaService {

    @Autowired
    private ReceitaRepository receitaRepository;

    @Autowired
    CategoriaRepository categoriaRepository;
    public Receita salvar(Receita receita) {
        if (receita.isRestricao()){
            if (receita.getCategoria() == null){
                return null;
            }
        }
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
