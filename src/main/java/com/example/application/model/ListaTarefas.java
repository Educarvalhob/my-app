package com.example.application.model;

public class ListaTarefas{
    private int id;
    private String data_tarefa;
    private String descricao_tarefa;
    private String observacao;
    private Status status_tarefa;
    private Categoria categoria_tarefa;
    private Prioridade prioridade_tarefa;
    private Responsavel responsavel_tarefa;
    
    public ListaTarefas(){
        
    }

    public ListaTarefas(int id, String data_tarefa, String descricao_tarefa, String observacao, Status status_tarefa,
            Categoria categoria_tarefa, Prioridade prioridade_tarefa, Responsavel responsavel_tarefa) {
        this.id = id;
        this.data_tarefa = data_tarefa;
        this.descricao_tarefa = descricao_tarefa;
        this.observacao = observacao;
        this.status_tarefa = status_tarefa;
        this.categoria_tarefa = categoria_tarefa;
        this.prioridade_tarefa = prioridade_tarefa;
        this.responsavel_tarefa = responsavel_tarefa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData_tarefa() {
        return data_tarefa;
    }

    public void setData_tarefa(String data_tarefa) {
        this.data_tarefa = data_tarefa;
    }

    public String getDescricao_tarefa() {
        return descricao_tarefa;
    }

    public void setDescricao_tarefa(String descricao_tarefa) {
        this.descricao_tarefa = descricao_tarefa;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Status getStatus_tarefa() {
        return status_tarefa;
    }

    public void setStatus_tarefa(Status status_tarefa) {
        this.status_tarefa = status_tarefa;
    }

    public Categoria getCategoria_tarefa() {
        return categoria_tarefa;
    }

    public void setCategoria_tarefa(Categoria categoria_tarefa) {
        this.categoria_tarefa = categoria_tarefa;
    }

    public Prioridade getPrioridade_tarefa() {
        return prioridade_tarefa;
    }

    public void setPrioridade_tarefa(Prioridade prioridade_tarefa) {
        this.prioridade_tarefa = prioridade_tarefa;
    }

    public Responsavel getResponsavel_tarefa() {
        return responsavel_tarefa;
    }

    public void setResponsavel_tarefa(Responsavel responsavel_tarefa) {
        this.responsavel_tarefa = responsavel_tarefa;
    }
}