package service;

import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * REST Web Service
 *
 * @author Arnaldo Junior
 */
@Path("/hello")
public class GenericResource {

    @GET
    @Produces("text/plain")
    public String getClichedMessage() {
        return "Hello";
    }
}
