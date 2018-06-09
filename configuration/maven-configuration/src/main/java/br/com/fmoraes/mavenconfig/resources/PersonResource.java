package br.com.fmoraes.mavenconfig.resources;

import br.com.fmoraes.mavenconfig.model.Person;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

/**
 *
 * @author Felipe
 */
@Path("person")
@Stateless
public class PersonResource {

    @PersistenceContext
    private EntityManager em;
    
    @POST
    public void create() {
        em.persist(new Person("Felipe"));
    }
    
}
