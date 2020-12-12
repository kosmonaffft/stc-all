package university.innopolis.stc.logging;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
@EqualsAndHashCode
@AllArgsConstructor
public class AnotherClass {

    @NonNull
    private String field;

    private String str;

    public static void method() {
        log.warn("Another error!!!");
        log.info("Info");
        log.debug("Ddebug");
        log.trace("Trace");
    }
}
