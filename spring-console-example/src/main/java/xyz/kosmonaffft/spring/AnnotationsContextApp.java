package xyz.kosmonaffft.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import xyz.kosmonaffft.beans.AnotherHello;
import xyz.kosmonaffft.beans.Hello;

public class AnnotationsContextApp {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("xyz.kosmonaffft.annotatedBeans");
        Hello bean = context.getBean(Hello.class, "hello");
        bean.sayHello();

        AnotherHello hello = context.getBean(AnotherHello.class);
        hello.sayHello();
    }
}
