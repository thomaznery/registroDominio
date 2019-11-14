package br.com.registroDominio.service;



import br.com.registroDominio.modelo.Dominio;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class DominioService {

    @Inject
    EntityManager em ;

}
