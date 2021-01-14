package xyz.kosmonaffft.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import xyz.kosmonaffft.beans.AnotherHello;
import xyz.kosmonaffft.beans.Hello;
import xyz.kosmonaffft.wiring.annotations.BeanA;

public class AnnotationsContextApp {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("xyz.kosmonaffft.annotatedBeans", "xyz.kosmonaffft.wiring.annotations");
        Hello bean = context.getBean(Hello.class);
        bean = context.getBean(Hello.class);
        bean = context.getBean(Hello.class);
        bean.sayHello();

        AnotherHello hello = (AnotherHello) context.getBean("anotherHello");
        hello = (AnotherHello) context.getBean("anotherHello");
        hello = (AnotherHello) context.getBean("anotherHello");
        hello.sayHello();

//        BeanA beanAAnnotations = context.getBean(BeanA.class);
        xyz.kosmonaffft.wiring.xml.BeanA beanACode = context.getBean(xyz.kosmonaffft.wiring.xml.BeanA.class);
        System.out.println("Pause");
    }
}
