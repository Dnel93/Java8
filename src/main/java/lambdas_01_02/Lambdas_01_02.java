package lambdas_01_02;

import java.util.function.BiFunction;

public class Lambdas_01_02 {
    public static void main(String[] args) {
        // Anonymous Inner Class: Runnable
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("run 1");
            }
        };

        //  Lambda version of Runnable (no arguments)
        Runnable r2 = () -> System.out.println("run 2");

        // Start both threads
        r1.run();
        r2.run();

        // Using an existing functional interface BiFunction
        BiFunction<String,String,String> concat = (a,b) -> a+ b;
        String sentence = concat.apply("Today is ", "a great day");
        System.out.println(sentence);

    }
}
