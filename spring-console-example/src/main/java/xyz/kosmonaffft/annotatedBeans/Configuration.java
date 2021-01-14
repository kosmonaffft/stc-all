package xyz.kosmonaffft.annotatedBeans;

import org.springframework.context.annotation.Bean;
import xyz.kosmonaffft.beans.AnotherHello;

@org.springframework.context.annotation.Configuration
public class Configuration {

    @Bean
    public AnotherHello anotherHello() {
        return new AnotherHelloBean();
    }
}
