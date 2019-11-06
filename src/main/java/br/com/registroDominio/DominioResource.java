package br.com.registroDominio;

import br.com.registroDominio.modelo.Dominio;
import br.com.registroDominio.modelo.Registro;
import br.com.registroDominio.repository.DominioRepository;
import com.google.gson.Gson;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Path("/dominio")
@Produces(MediaType.APPLICATION_JSON)
public class DominioResource {

    private static final org.jboss.logging.Logger LOG = Logger.getLogger(DominioResource.class);
    @Inject
    DominioRepository domRepo;

    @GET
    public String findAll() {
        return new Gson().toJson(Dominio.listAll());
    }

    @GET
    @Path("{id}")
    public String find(@PathParam("id") Long id){
        Dominio dominio = Dominio.find("dom_codigo",id).firstResult();
        return new Gson().toJson(dominio);
    }

    @GET
    @Path("/registros/{domId}")
    public String findByRegId(@PathParam("domId") Long domId){
        List<Registro> list = Registro.find("reg_cod_dominio", domId).list();
        return new Gson().toJson(list);
    }


}