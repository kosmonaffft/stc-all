package xyz.kosmonaffft.annotatedBeans;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import xyz.kosmonaffft.beans.AnotherHello;
import xyz.kosmonaffft.wiring.xml.BeanA;
import xyz.kosmonaffft.wiring.xml.BeanB;
import xyz.kosmonaffft.wiring.xml.BeanC;
import xyz.kosmonaffft.wiring.xml.BeanD;
import xyz.kosmonaffft.wiring.xml.BeanE;

import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_SINGLETON;

@Configuration
public class MyConfiguration {

    @Autowired
    private BeanE beanE;

    @Autowired
    private BeanB beanB;

    @Bean
    @Scope(SCOPE_SINGLETON)
    public AnotherHello anotherHello() {
        return new AnotherHelloBean();
    }

    @Bean
    public BeanA beanA() {
        BeanA beanA = new BeanA();
        beanA.setBeanB(beanB);
        return beanA;
    }

    @Bean
    public BeanB beanB(BeanC beanC) {
        return new BeanB(beanC);
    }

    @Bean
    public BeanC beanC(BeanD beanD) {
        BeanC beanC = new BeanC();
        beanC.setBeanD(beanD);
        return beanC;
    }

    @Bean
    public BeanD beanD() {
        return new BeanD(beanE);
    }

    @Bean
    public BeanE beanE() {
        return new BeanE();
    }

    @Bean
    public Cache<String, String> myGuavaCache() {
        return CacheBuilder.newBuilder().build();
    }
}
