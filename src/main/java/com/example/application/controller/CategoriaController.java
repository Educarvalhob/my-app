package com.example.application.controller;

import com.example.application.repository.CategoriaDAO;

import java.util.List;

import com.example.application.model.Categoria;

public class CategoriaController {
    CategoriaDAO dao = new CategoriaDAO();

    public boolean inserir(Categoria categoria){
        return dao.inserir(categoria);
    }

    public boolean alterar(Categoria categoria){
        return dao.alterar(categoria);
    }

    public boolean excluir(Categoria categoria){
        return dao.excluir(categoria);
    }

    public Categoria pesquisar(Categoria categoria){
        return dao.pesquisar(categoria.getId());
    }

    public List<Categoria> pesquisarTodos(){
        return dao.pesquisarTodos();
    }
}
