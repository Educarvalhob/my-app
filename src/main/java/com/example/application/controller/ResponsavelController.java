package com.example.application.controller;

import com.example.application.repository.ResponsavelDAO;

import java.util.List;

import com.example.application.model.Responsavel;

public class ResponsavelController {
    ResponsavelDAO dao = new ResponsavelDAO();

    public boolean inserir(Responsavel responsavel){
        return dao.inserir(responsavel);
    }

    public boolean alterar(Responsavel responsavel){
        return dao.alterar(responsavel);
    }

    public boolean excluir(Responsavel responsavel){
        return dao.excluir(responsavel);
    }

    public Responsavel pesquisar(Responsavel responsavel){
        return dao.pesquisar(responsavel.getId());
    }

    public List<Responsavel> pesquisarTodos(){
        return dao.pesquisarTodos();
    }
}
