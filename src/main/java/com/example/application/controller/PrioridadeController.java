package com.example.application.controller;

import com.example.application.repository.PrioridadeDAO;

import java.util.List;

import com.example.application.model.Prioridade;

public class PrioridadeController {
    PrioridadeDAO dao = new PrioridadeDAO();

    public boolean inserir(Prioridade prioridade){
        return dao.inserir(prioridade);
    }

    public boolean alterar(Prioridade prioridade){
        return dao.alterar(prioridade);
    }

    public boolean excluir(Prioridade prioridade){
        return dao.excluir(prioridade);
    }

    public Prioridade pesquisar(Prioridade prioridade){
        return dao.pesquisar(prioridade.getId());
    }

    public List<Prioridade> pesquisarTodos(){
        return dao.pesquisarTodos();
    }
}
