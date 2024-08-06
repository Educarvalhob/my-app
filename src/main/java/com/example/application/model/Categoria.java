package com.example.application.model;

public class Categoria {
    private int id;
    private String descricao;
    
    public Categoria(){

    }

    public Categoria(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public static Categoria fromId(int id) {
        Categoria categoria = new Categoria();
        categoria.setId(id);
        return categoria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
