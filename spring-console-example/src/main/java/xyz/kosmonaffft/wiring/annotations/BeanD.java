package xyz.kosmonaffft.wiring.annotations;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class BeanD {

    @PostConstruct
    public void init() {
    }
}
