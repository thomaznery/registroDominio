package br.com.registroDominio;

import br.com.registroDominio.modelo.Dominio;
import br.com.registroDominio.modelo.Registro;
import com.google.gson.Gson;
import org.jboss.logging.Logger;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


@Path("/dominio")
@Consumes(MediaType.APPLICATION_JSON)
public class DominioResource {

    private static final org.jboss.logging.Logger LOG = Logger.getLogger(DominioResource.class);

    @GET
    public String dominio() {
        return "Modulo: registroDominio";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/all")
    public String findAll() {
        return new Gson().toJson(Dominio.listAll());
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String find(@PathParam("id") Long id){
        Dominio dominio = Dominio.find("dom_codigo",id).firstResult();
        return new Gson().toJson(dominio);
    }
}