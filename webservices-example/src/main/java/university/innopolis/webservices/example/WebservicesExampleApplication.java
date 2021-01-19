package university.innopolis.webservices.example;

import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.ws.config.annotation.EnableWs;

import javax.xml.ws.Endpoint;

@EnableWs
@SpringBootApplication
public class WebservicesExampleApplication {

    @Bean
    public IHelloService helloService() {
        return new HelloService();
    }

    @Bean
    public ServletRegistrationBean wsDispatcherServlet() {
        CXFServlet servlet = new CXFServlet();
        return new ServletRegistrationBean(servlet, "/services/*");
    }

    @Bean(name = "cxf")
    public SpringBus springBus() {
        return new SpringBus();
    }

    @Bean
    public Endpoint helloServiceEndpoint() {
        Endpoint e = new EndpointImpl(springBus(), helloService());
        e.publish("helloservice");
        return e;
    }

    public static void main(String[] args) {
        SpringApplication.run(WebservicesExampleApplication.class, args);
    }
}
