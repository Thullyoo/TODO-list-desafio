package entity;

import java.time.LocalDate;

public class Tarefa{

    private String nome;

    private String descricao;

    private LocalDate dataDeTermino;

    private int nivelDePrioridade;

    private Categoria categoria;

    private Status status;

    public Tarefa(String nome, String descricao, LocalDate dataDeTermino, int nivelDePrioridade, Categoria categoria, Status status) {
        this.nome = nome;
        this.descricao = descricao;
        this.dataDeTermino = dataDeTermino;
        this.nivelDePrioridade = nivelDePrioridade;
        this.categoria = categoria;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Tarefa{" +
                "nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", dataDeTermino=" + dataDeTermino +
                ", nivelDePrioridade=" + nivelDePrioridade +
                ", categoria='" + categoria + '\'' +
                ", status=" + status +
                '}';
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataDeTermino() {
        return dataDeTermino;
    }

    public void setDataDeTermino(LocalDate dataDeTermino) {
        this.dataDeTermino = dataDeTermino;
    }

    public int getNivelDePrioridade() {
        return nivelDePrioridade;
    }

    public void setNivelDePrioridade(int nivelDePrioridade) {
        this.nivelDePrioridade = nivelDePrioridade;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
