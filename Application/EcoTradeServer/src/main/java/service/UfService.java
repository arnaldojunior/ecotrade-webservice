package service;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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
    
    @PersistenceContext(unitName = "ecoTradePU")
    private EntityManager em;
    
    public UfService() {
        super(Uf.class);
    }
    
    public EntityManager getEntityManager() {
        return em;
    }

    @GET
    @Path("{id}")
    @Produces("application/json")
    public Uf find (@PathParam("id") String id) {
        //return super.find(id);
        Query q = getEntityManager().createNamedQuery("Uf.findById").setParameter("id", id);
        return (Uf) q.getSingleResult();
    }
    
    @GET
    @Override
    @Produces("application/json")
    public List<Uf> findAll() {
        return super.findAll();
    }
}
