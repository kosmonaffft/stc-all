package xyz.kosmonaffft.annotatedBeans;

import org.springframework.stereotype.Component;
import xyz.kosmonaffft.beans.Hello;

@Component("hello")
public class HelloImpl implements Hello {

    @Override
    public void sayHello() {
        System.out.println("Hello, world!!!");
    }
}
