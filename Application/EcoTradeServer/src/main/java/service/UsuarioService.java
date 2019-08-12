package service;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import model.Usuario;

/**
 *
 * @author Arnaldo Junior
 */
@Stateless
@Path("/usuario")
public class UsuarioService extends AbstractFacade<Usuario> {

    @PersistenceContext(unitName = "ecoTradePU")
    private EntityManager em;
    
    public UsuarioService() {
        super(Usuario.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @GET
    @Path("id/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Usuario findById(@PathParam("id") String id) {
        return super.find(Long.valueOf(id));
    }
    
    @GET
    @Path("email/{email}")
    @Produces(MediaType.APPLICATION_JSON)
    public Usuario findByEmail(@PathParam("email") String email) {
        return em.createQuery("SELECT u FROM Usuario u WHERE u.email = :email", Usuario.class)
                .setParameter("email", email).getSingleResult();
    }

    @GET
    @Override
    @Produces(MediaType.APPLICATION_JSON)
    public List<Usuario> findAll() {
        return super.findAll();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(Usuario usuario) {
        try {
            if (usuario.getId() != null) {
                em.merge(usuario);
            } else {
                em.persist(usuario);
            }
            return Response.status(201).entity(usuario).build();
        } catch (IllegalStateException | SecurityException e) {
            throw new WebApplicationException(500);
        }
    }
}
