package service;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import model.Uf;

/**
 *
 * @author Arnaldo Junior
 */
@Stateless
@Path("/uf")
public class UfService extends AbstractFacade<Uf> {
    
    @PersistenceUnit(unitName = "ecoTradePU")
    private EntityManagerFactory emf;
    
    public UfService() {
        super(Uf.class);
    }
    
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    @GET
    @Path("{id}")
    @Produces("application/json")
    public Uf find (@PathParam("id") String id) {
        return super.find(id);
    }
    
    @GET
    @Override
    @Produces("application/json")
    public List<Uf> findAll() {
        return super.findAll();
    }
}
