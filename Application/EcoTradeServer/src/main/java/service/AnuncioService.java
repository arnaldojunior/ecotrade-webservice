package service;

import java.time.LocalDateTime;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import model.Anuncio;
import model.Categoria;
import model.Cidade;

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
    @Path("usuario/{usuario}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Anuncio> findByUsuario(@PathParam("usuario") String usuario) {
        return em.createQuery("SELECT a FROM Anuncio a WHERE a.usuario.id = ?1", Anuncio.class)
                .setParameter(1, usuario).getResultList();
    }
    
    @GET
    @Override
    @Produces(MediaType.APPLICATION_JSON)
    public List<Anuncio> findAll() {
        return super.findAll();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(Anuncio anuncio) {
        System.out.println("ANÚNCIO: "+ anuncio.toString());
        try {
            Query query = em.createQuery("SELECT c FROM Cidade c WHERE c.nome = ?1 AND c.uf.uf = ?2")
                    .setParameter(1, anuncio.getCidade().getNome())
                    .setParameter(2, anuncio.getCidade().getUf().getUf());
            Cidade cidade = (Cidade) query.getSingleResult();
            anuncio.setCidade(cidade);
            
            query = em.createQuery("SELECT c FROM Categoria c WHERE c.nome = ?1")
                    .setParameter(1, anuncio.getCategoria().getNome());
            Categoria categoria = (Categoria) query.getSingleResult();
            anuncio.setCategoria(categoria);
            
            anuncio.setQuando(LocalDateTime.now());
            
            if (anuncio.getId() != null) {
                em.merge(anuncio);
            } else {
                em.persist(anuncio);
            }
            return Response.status(201).entity(anuncio).build();
        } catch (IllegalStateException | SecurityException e) {
            throw new WebApplicationException(500);
        }
    }
}
