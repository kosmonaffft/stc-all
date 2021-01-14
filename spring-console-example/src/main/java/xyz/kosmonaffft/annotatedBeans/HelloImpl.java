package xyz.kosmonaffft.annotatedBeans;

import com.google.common.cache.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import xyz.kosmonaffft.beans.Hello;

import javax.annotation.PostConstruct;

import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_PROTOTYPE;

@Scope(SCOPE_PROTOTYPE)
@Component("hello")
public class HelloImpl implements Hello {

    @Autowired
    private Cache<String, String> cache;

    @PostConstruct
    public void init() {
        System.out.println("Hello bean initialized!!!");
    }

    @Override
    public void sayHello() {
        System.out.println("Hello, world!!!");
    }
}
