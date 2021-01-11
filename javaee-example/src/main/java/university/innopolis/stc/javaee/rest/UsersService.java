package university.innopolis.stc.javaee.rest;

import university.innopolis.stc.javaee.dto.User;
import university.innopolis.stc.javaee.ejb.HelloEjb;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

@Stateless
@Path("users")
public class UsersService {

    @EJB
    private HelloEjb helloEjb;

    @GET
    @Produces("application/json")
    public List<User> getAllUsers() {
        return helloEjb.getAllUsers();
    }
}
