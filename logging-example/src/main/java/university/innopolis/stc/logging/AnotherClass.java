package university.innopolis.stc.logging;

import lombok.Cleanup;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import lombok.val;

@Slf4j
public class AnotherClass {

    @SneakyThrows
    public static void method() {
        @Cleanup("closeUser") val root = new User("root");
        log.error("I'm AnotherClass error");
        log.warn("I'm AnotherClass warn");
        log.info("I'm AnotherClass info from {}", root);
        log.debug("I'm AnotherClass debug");
        log.trace("I'm AnotherClass trace");
    }
}
