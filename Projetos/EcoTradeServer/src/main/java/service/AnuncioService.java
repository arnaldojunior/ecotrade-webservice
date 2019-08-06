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
import model.Anuncio;

/**
 *
 * @author Arnaldo Junior
 */
@Stateless
@Path("/anuncio")
public class AnuncioService extends AbstractFacade<Anuncio> {

    @PersistenceContext(unitName = "ecoTradePU")
    private EntityManager em;

    public AnuncioService() {
        super(Anuncio.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @GET
    @Path("id/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Anuncio findById(@PathParam("id") String id) {
        return super.find(Long.valueOf(id));
    }
    
    @GET
    @Path("{categoria}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Anuncio> findByCategoria(@PathParam("categoria") String categoria) {
        return em.createQuery("SELECT a FROM Anuncio a WHERE LOWER(a.categoria.nome) = ?1", Anuncio.class)
                .setParameter(1, categoria).getResultList();
    }
    
    @GET
    @Override
    @Produces(MediaType.APPLICATION_JSON)
    public List<Anuncio> findAll() {
        return super.findAll();
    }
}
