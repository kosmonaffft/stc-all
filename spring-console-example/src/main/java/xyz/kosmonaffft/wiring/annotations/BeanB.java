package xyz.kosmonaffft.wiring.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BeanB {

    private final BeanC beanC;

    @Autowired
    public BeanB(BeanC beanC) {
        this.beanC = beanC;
    }
}
