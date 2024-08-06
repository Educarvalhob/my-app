package com.example.application.controller;

import com.example.application.repository.StatusDAO;
import com.example.application.model.Status;

public class StatusController {
    StatusDAO dao = new StatusDAO();

    public boolean inserir(Status status){
        return dao.inserir(status);
    }

    public boolean alterar(Status status){
        return dao.alterar(status);
    }

    public boolean excluir(Status status){
        return dao.excluir(status);
    }

    public Status pesquisar(Status status){
        return dao.pesquisar(status.getId());
    }
}
