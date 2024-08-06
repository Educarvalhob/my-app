package com.example.application.controller;

import com.example.application.repository.ListaTarefasDAO;

import java.util.List;

import com.example.application.model.ListaTarefas;

public class ListaTarefasController {
    ListaTarefasDAO dao = new ListaTarefasDAO();

    public boolean inserir(ListaTarefas listaTarefas){
        return dao.inserir(listaTarefas);
    }

    public boolean alterar(ListaTarefas listaTarefas){
        return dao.alterar(listaTarefas);
    }

    public boolean excluir(ListaTarefas listaTarefas){
        return dao.excluir(listaTarefas);
    }

    public ListaTarefas pesquisar(ListaTarefas listaTarefas){
        return dao.pesquisar(listaTarefas.getId());
    }

    public List<ListaTarefas> pesquisarTodos(){
        return dao.pesquisarTodos();
    }
}
