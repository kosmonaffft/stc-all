package university.innopolis.webservices.example;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.io.IOException;

// Add comment.
@WebService
public interface IHelloService {

    @WebMethod
    String sayHello(String name) throws IOException;
}
