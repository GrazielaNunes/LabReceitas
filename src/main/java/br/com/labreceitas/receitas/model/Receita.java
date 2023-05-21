package br.com.labreceitas.receitas.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "receita")
public class Receita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name="id_categoria", foreignKey = @ForeignKey(name = "fk_categoria"))
    private Categoria categoria;

    @Column(length = 60)
    private String nome;

    @Column()
    private String ingredientes;

    @Column()
    private String modoPreparo;

    private boolean restricao;
}
