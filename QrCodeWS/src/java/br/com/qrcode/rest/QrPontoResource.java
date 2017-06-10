package br.com.qrcode.rest;

import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

@Path("QrPonto")
public class QrPontoResource {

    public QrPontoResource() {
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("hello/{nome}")
    public String getJson(@PathParam("nome") String nome) {
        return "Hello World GET "+nome;
    }

}
