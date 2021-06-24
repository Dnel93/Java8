package lambdas_02_02;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Lambdas_02_02 {
    public static void main(String[] args) {

        Arrays.asList("red", "green", "blue")
                .stream()
                .sorted()
                .findFirst()
                .ifPresent(System.out::println);

        /*
            Example of Stream.of with a filter
            ---------------------------------------------------
            if the foreach is removed, nothing will print,
            the foreach makes it a terminal event
        */
        Stream.of("apple","pear","banana","cherry","apricot")
                .filter(fruit -> fruit.startsWith("a"))
                .forEach(fruit -> System.out.println("Starts with A: " + fruit));

        // using a stream and map operation to create a list of words in caps
        List<String> collected = Stream.of("Java", "Rocks")
                .map(String::toUpperCase)
                .collect(toList());

        System.out.println(collected);
    }
}
