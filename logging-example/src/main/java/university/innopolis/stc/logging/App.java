package university.innopolis.stc.logging;

import lombok.Cleanup;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hello world!
 */
public class App {

    private final static Logger logger = LoggerFactory.getLogger(App.class);

    @SneakyThrows
    public static void main(String[] args) {
        logger.error("Hello, world!!!");
        logger.trace("Trace from app");
        AnotherClass.method();
        AnotherClass c1 = new AnotherClass("f", "c1");
        AnotherClass c2 = new AnotherClass("f", "c2");
        System.out.println(c1.equals(c2));

        new AnotherClass("null", "");
        System.out.println(c1.toString());

        @Cleanup("getField") AnotherClass a = new AnotherClass("", "");
    }
}
