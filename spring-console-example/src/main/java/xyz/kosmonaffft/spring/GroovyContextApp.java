package xyz.kosmonaffft.spring;

import org.springframework.context.support.GenericGroovyApplicationContext;
import xyz.kosmonaffft.beans.Hello;

public class GroovyContextApp {

    public static void main(String[] args) {
        GenericGroovyApplicationContext context = new GenericGroovyApplicationContext();
        context.load("classpath:/context.groovy");
        context.refresh();
        Hello bean = context.getBean(Hello.class);
        bean.sayHello();
    }
}
