package xyz.kosmonaffft.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import xyz.kosmonaffft.beans.Hello;
import xyz.kosmonaffft.wiring.xml.BeanA;

public class XmlContextApp {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/context.xml");
        Hello bean = context.getBean(Hello.class);
        bean.sayHello();

        context.getBean(BeanA.class);
    }
}
