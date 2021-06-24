package lambdas_01_01;

import java.util.Locale;
import java.util.function.*;

public class Lambdas_01_01 {

    public static void main(String[] args) {
        /*
         * Predicate - Takes one argument returns a boolean
         *  Example: Using the test method of Predicate
         */
        Predicate<String> stringLen = s -> s.length() < 10;
        System.out.println(stringLen.test("Apples") + " - Apples is less than 10");

        /*
         * Consumer - Accepts single argument with no return value
         * Example: Consumer uses accept method
         */
        Consumer<String> consumerStr = s -> System.out.println(s.toLowerCase(Locale.ROOT));
        consumerStr.accept("ABCDefghijklmnopQRSTuvWxyZ");

        /*
         * Function - Accepts one argument and produces a result
         * Example: Function example
         */
        Function<Integer, String> converter = num -> Integer.toString(num);
        System.out.println("length of 26: " + converter.apply(26).length());

        /*
         * Supplier - Represents a supplier of results
         * Example: Function example
         */
        Supplier<String> s = () -> "Java is fun";
        System.out.println(s.get());

        /*
         * BinaryOperator - Takes two arguments and returns one
         * Example: Binary Operator Example
         */
        BinaryOperator<Integer> add = (a, b) -> a + b;
        System.out.println("Add 10 + 25: " + add.apply(10, 25));

        /*
         * UnaryOperator - Takes one argument with a return value
         * Example: Unary Operator Example
         */
        UnaryOperator<String> str = msg -> msg.toUpperCase();
        System.out.println(str.apply("This is my message in upper case"));
    }
}
