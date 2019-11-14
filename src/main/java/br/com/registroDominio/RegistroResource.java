package br.com.registroDominio;

import br.com.registroDominio.modelo.Registro;
import com.google.gson.Gson;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import org.jboss.logging.Logger;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/registro")
@Consumes(MediaType.APPLICATION_JSON)
public class RegistroResource {

    private static final org.jboss.logging.Logger LOG = Logger.getLogger(DominioResource.class);

    @GET
    @Path("/{codDominio}")
    @Produces(MediaType.APPLICATION_JSON)
    public String buscarPeloCodDominio(@PathParam("codDominio") Integer codDominio){

        return new Gson().toJson(Registro.find("reg_cod_dominio",
                codDominio).list());
    }


}
