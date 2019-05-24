package service;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import model.Cidade;

/**
 *
 * @author Arnaldo Junior
 */
@Stateless
@Path("/cidade")
public class CidadeService extends AbstractFacade<Cidade> {

    @PersistenceContext(unitName = "ecoTradePU")
    private EntityManager em;

    public CidadeService() {
        super(Cidade.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Cidade find(@PathParam("id") String id) {
        return super.find(Long.valueOf(id));
    }
    
    @GET
    @Override
    @Produces(MediaType.APPLICATION_JSON)
    public List<Cidade> findAll() {
        return super.findAll();
    }
}
