package university.innopolis.stc.javaee.rest;

import university.innopolis.stc.javaee.ejb.HelloEjb;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

@Stateless
@Path("hello")
public class HelloService {

    @EJB
    private HelloEjb helloEjb;

    @GET
    @Path("by_name")
    public String helloByNameQuery(
            @QueryParam("name") @DefaultValue("Anton V. Kirilchik") String name) {

        return "Hello, " + name + "!!!";
    }

    @GET
    @Path("by_name/{name}")
    public String helloByNamePath(@PathParam("name") String name) {

        return "Hello, " + name + "!!!";
    }
}
