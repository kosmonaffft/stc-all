package forum.utils;

import lombok.experimental.UtilityClass;

import java.util.Optional;
import java.util.function.Supplier;

@UtilityClass
public class OptionalUtils {

    public static <T> Optional<T> ofThrowable(Supplier<T> supplier) {
        try {
            return Optional.of(supplier.get());
        } catch (Throwable t) {
            return Optional.empty();
        }
    }
}
