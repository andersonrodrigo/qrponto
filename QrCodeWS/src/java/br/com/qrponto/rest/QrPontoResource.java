package br.com.qrponto.rest;

import br.com.qrponto.bean.Usuario;
import br.com.qrponto.mock.Mock;
import com.google.gson.Gson;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("QrPonto")
public class QrPontoResource {

    private Gson gson = new Gson();

    public QrPontoResource() {
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/login")
    public Response login(String jsonUsuario) {
        try {
            Usuario u = this.gson.fromJson(jsonUsuario, Usuario.class);
            if (!u.getLogin().isEmpty() && !u.getSenha().isEmpty()) {
                u = Mock.carregaUsuario1(u);
                return Response.status(Response.Status.OK).entity(gson.toJson(u)).build();
            } else {
                return Response.status(Response.Status.BAD_REQUEST).entity("USUÁRIO OU SENHA EM BRANCO").build();
            }
        } catch (Exception e) {
            Logger.getLogger(QrPontoResource.class.getName()).log(Level.SEVERE, null, e);
            return Response.status(Response.Status.NOT_ACCEPTABLE).entity(null).build();
        }
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getqrcode")
    public Response getQrCode(String jsonUsuario) {
        return Response.status(Response.Status.OK).entity("http://localhost:8080/QrCodeWS/webresources/QrPonto/").build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/enviaqrcode")
    public Response enviaQrCode(String url) {
        return Response.status(Response.Status.OK).entity(url).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/relatoriobatida/{dataini}/{datafim}")
    public Response getRelatorioBatida(@PathParam("dataini") String dataini, @PathParam("datafim") String datafim,
            String jsonUsuario) {
        /*
        Regex : dd/MM/yyyy
         */
        String regexData = "\"([0-9]{2})/([0-9]{2})/([0-9]{4})\"";

        if (dataini.matches(regexData) && datafim.matches(regexData) && !jsonUsuario.isEmpty()) {
            try {
                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                Date datainiDate = formato.parse(dataini);
                Date datafimDate = formato.parse(datafim);

                Usuario u = this.gson.fromJson(jsonUsuario, Usuario.class);

                return Response.status(Response.Status.BAD_REQUEST).entity("DATAS NO FORMATO INVÁLIDOS").build();
            } catch (ParseException ex) {
                Logger.getLogger(QrPontoResource.class.getName()).log(Level.SEVERE, null, ex);
                return Response.status(Response.Status.BAD_REQUEST).entity("ERRO!").build();
            }
        } else {
            return Response.status(Response.Status.BAD_REQUEST).entity("DATAS NO FORMATO INVÁLIDOS").build();
        }
    }

}
