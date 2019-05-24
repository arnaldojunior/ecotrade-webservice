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
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Usuario find(@PathParam("id") String id) {
        return super.find(Long.valueOf(id));
    }
    
    @GET
    @Override
    @Produces(MediaType.APPLICATION_JSON)
    public List<Usuario> findAll() {
        return super.findAll();
    }
}
