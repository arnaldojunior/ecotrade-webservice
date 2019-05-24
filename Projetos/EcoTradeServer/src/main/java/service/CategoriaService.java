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
import model.Categoria;

/**
 *
 * @author Arnaldo Junior
 */
@Stateless
@Path("/categoria")
public class CategoriaService extends AbstractFacade<Categoria> {

    @PersistenceContext(unitName = "ecoTradePU")
    private EntityManager em;
    
    public CategoriaService() {
        super(Categoria.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Categoria find (@PathParam("id") String id) {
        return super.find(Long.valueOf(id));
    }
    
    @GET
    @Override
    @Produces(MediaType.APPLICATION_JSON)
    public List<Categoria> findAll() {
        return super.findAll();
    }
}
