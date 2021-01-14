package xyz.kosmonaffft.wiring.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BeanC {

    private BeanD beanD;

    public BeanD getBeanD() {
        return beanD;
    }

    @Autowired
    public void setBeanD(BeanD beanD) {
        this.beanD = beanD;
    }
}
