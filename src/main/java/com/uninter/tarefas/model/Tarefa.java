package com.uninter.tarefas.model;

import jakarta.persistence.*;

@Entity
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String dataEntrega; // String para facilitar o formato "12/12/2025" solicitado
    private String responsavel;

    // Getters e Setters (Obrigatório gerar para todos os campos)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getDataEntrega() { return dataEntrega; }
    public void setDataEntrega(String dataEntrega) { this.dataEntrega = dataEntrega; }
    public String getResponsavel() { return responsavel; }
    public void setResponsavel(String responsavel) { this.responsavel = responsavel; }
}