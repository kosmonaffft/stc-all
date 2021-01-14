package xyz.kosmonaffft.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import xyz.kosmonaffft.beans.Hello;

public class XmlContextApp {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/context.xml");
        Hello bean = context.getBean(Hello.class);
        bean.sayHello();
    }
}
