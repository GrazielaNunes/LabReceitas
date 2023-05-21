package br.com.labreceitas.receitas.repository;

import br.com.labreceitas.receitas.model.Receita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceitaRepository extends JpaRepository<Receita, Long > {
}
