package br.senai.model;

import jakarta.persistence.*;

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

    public Receita() {
    }

    public Receita(Long id, Categoria categoria, String nome, String ingredientes, String modoPreparo, boolean restricao) {
        this.id = id;
        this.categoria = categoria;
        this.nome = nome;
        this.ingredientes = ingredientes;
        this.modoPreparo = modoPreparo;
        this.restricao = restricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    public String getModoPreparo() {
        return modoPreparo;
    }

    public void setModoPreparo(String modoPreparo) {
        this.modoPreparo = modoPreparo;
    }

    public boolean isRestricao() {
        return restricao;
    }

    public void setRestricao(boolean restricao) {
        this.restricao = restricao;
    }
}
