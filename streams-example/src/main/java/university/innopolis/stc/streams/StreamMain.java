package university.innopolis.stc.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamMain {

    public static void main(String[] args) {
        List<String> strings = IntStream.range(0, 1000)
                .filter(x -> x % 2 != 0)
                .map(x -> x * 2)
                .mapToObj(String::valueOf)
                .skip(100)
                .limit(10)
                .collect(Collectors.toList());

        strings.forEach(System.out::println);

        String s = strings.stream().collect(Collectors.joining(", "));
        System.out.println(s);

        Double mean = strings.stream()
                .collect(Collectors.averagingDouble(Double::parseDouble));
        System.out.println(mean);

        ArrayList<String> myCollectorExample = strings.stream()
                .parallel()
                .unordered()
                .collect(
                        (Supplier<ArrayList<String>>) () -> {
                            return new ArrayList<String>();
                        },
                        (list, element) -> {
                            list.add(element);
                        },
                        (result, list) -> {
                            result.addAll(list);
                        }
                );
        System.out.println(myCollectorExample);
    }
}
