package br.com.qrponto.bean;

public class Perfil {
    
    private Integer id;
    private String nome;

    public Perfil(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }
    
    public Perfil(){
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
    
}
