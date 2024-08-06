package com.example.application.model;

public class Status {
    private int id;
    private String descricao;
    
    public Status(){

    }
    
    public Status(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public static Status fromId(int id) {
        Status status = new Status();
        status.setId(id);
        return status;
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
