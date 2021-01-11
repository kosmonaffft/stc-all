package university.innopolis.stc.javaee.jsf;

import university.innopolis.stc.javaee.ejb.HelloEjbClient;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named
@ApplicationScoped
public class JsfBean {

    @EJB
    private HelloEjbClient helloEjbClient;

    private String text;

    public String getMessage() {
        return helloEjbClient.getHelloMessage();
    }

    public void buttonClickHandler() {
        System.out.println(text);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
