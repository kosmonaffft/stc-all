package university.innopolis.webservices.example;

import java.io.IOException;

import static java.lang.String.format;

public class HelloService implements IHelloService {

    @Override
    public String sayHello(String name) throws IOException {
        if (name.length() > 10) {
            throw new IOException();
        }
        return format("Hello, %s", name);
    }
}
