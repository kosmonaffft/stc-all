package university.innopolis.stc.javaee.ejb;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless(name = "HelloEjbClient")
public class HelloEjbClient {

    @EJB
    private HelloEjb helloEjb;

    public String getHelloMessage() {
        return "Hello, " + String.join(", ", helloEjb.getAllUsersLogins());
    }
}
