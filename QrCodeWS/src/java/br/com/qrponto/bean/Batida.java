package br.com.qrponto.bean;

import java.util.Date;

public class Batida {
    
    private Integer id;
    private Date dataHora;
    private Usuario beanUsuario;
    private String urlGerada;
    private String urlBatida;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    public Usuario getBeanUsuario() {
        return beanUsuario;
    }

    public void setBeanUsuario(Usuario beanUsuario) {
        this.beanUsuario = beanUsuario;
    }

    public String getUrlGerada() {
        return urlGerada;
    }

    public void setUrlGerada(String urlGerada) {
        this.urlGerada = urlGerada;
    }

    public String getUrlBatida() {
        return urlBatida;
    }

    public void setUrlBatida(String urlBatida) {
        this.urlBatida = urlBatida;
    }
    
}
