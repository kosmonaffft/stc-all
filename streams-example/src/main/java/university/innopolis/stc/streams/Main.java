package university.innopolis.stc.streams;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {

       Arrays.stream(args)
                .forEach(System.out::println);

        Runnable x = () -> System.out.println("Hello from runnable!");

        Supplier<String> s = () -> "Hello from supplier!!!";

        Consumer<String> c = System.out::println;

        Function<String, String> f = s1 -> String.format("Hello, %s! I am a function!!!", s1);

        Function2<Integer, Integer, Integer> sum = (arg1, arg2) -> arg1 + arg2;

        x.run();
        System.out.println(s.get());
        c.accept("Hello from consumer!!!");
        System.out.println(f.apply("Anton"));

        System.out.println("1 + 1 = " + sum.apply(1, 1));
        System.out.println("10 + 1 = " + sum.apply(10, 1));
        System.out.println("100 + 1 = " + sum.apply(100, 1));

        SecurityLogger logger = new SecurityLogger();
        logger.doWithExceptionHandler(() -> {
            System.out.println("Предположительно все хорошо...");
        });

        logger.doWithExceptionHandler(() -> {
            System.out.println("Пытаемся взломать пентагон...");
            throw new RuntimeException();
        });

        new FileStorage().getFile(1, file -> {
            System.out.println(file);
        });
    }
}
