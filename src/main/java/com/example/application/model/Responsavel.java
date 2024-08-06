package com.example.application.model;

public class Responsavel {
    private int id;
    private String nome;
    
    public Responsavel(){

    }

    public Responsavel(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public static Responsavel fromId(int id) {
        Responsavel responsavel = new Responsavel();
        responsavel.setId(id);
        return responsavel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
