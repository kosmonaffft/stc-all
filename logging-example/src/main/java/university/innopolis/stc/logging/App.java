package university.innopolis.stc.logging;

import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.bridge.SLF4JBridgeHandler;

/**
 * Hello world!
 */
public class App {

    private final static Logger logger = LoggerFactory.getLogger(App.class);

    @SneakyThrows
    public static void main(String[] args) {
        SLF4JBridgeHandler.removeHandlersForRootLogger();
        SLF4JBridgeHandler.install();

        logger.error("I'm error");
        logger.warn("I'm warn");
        logger.info("I'm info");
        logger.debug("I'm debug");
        logger.trace("I'm trace");
        AnotherClass.method();
    }
}
