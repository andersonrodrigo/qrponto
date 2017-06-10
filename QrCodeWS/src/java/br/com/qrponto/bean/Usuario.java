package br.com.qrponto.bean;

public class Usuario {
    
    private Integer id;
    private String login;
    private String senha;
    private String nome;
    private Perfil perfil;

    public Usuario(String login, String senha, String nome, Perfil perfil) {
        this.login = login;
        this.senha = senha;
        this.nome = nome;
        this.perfil = perfil;
    }
    
    public Usuario(){
    }
    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }
    
}
