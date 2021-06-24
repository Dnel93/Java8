package lambdas_02_01;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

public class Lambdas_02_01 {
    public static void main(String[] args) {
        List<String> names = asList("Paul", "Jane", "Michaela", "Sam");

        // way to sort prior to Java 8 lambdas
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return b.compareTo(a);
            }
        });

        // first iteration with lambda
        Collections.sort(names, (String a, String b) -> {
            return b.compareTo(a);
        });

        // now remove the data types and allow the compile to infer the type
        Collections.sort(names, (a, b) -> b.compareTo(a));

        // total pages in your book collection
        Book book1 = new Book("Miss Peregrine's Home for Peculiar Children",
                "Ranson", "Riggs", 382);

        Book book2 = new Book("Harry Potter and The Sorcerers Stone",
                "JK", "Rowling", 411);

        Book book3 = new Book("The Cat in the Hat",
                "Dr", "Seuss", 45);

        // use .collect to aggregate values
        List<Book> books = asList(book1, book2, book3);
        int total = books.stream().collect(Collectors.summingInt(Book::getPages));
        //int total = books.stream().mapToInt(Book::getPages).sum(); <-- Another way to do this

        System.out.println(total);

        /*
            Use .collect to aggregate author first names into a list
            and .map to get the last name of the author
        */

        List<String> list = books.stream()
                .map(Book::getAuthorLName)
                .collect(Collectors.toList());

        System.out.println(list);

        // create a list with duplicates
        List<Book> dupBooks = asList(book1, book2, book3, book1, book2);
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("Before removing duplicates:");
        System.out.println("-----------------------------------------------------------------------");
        for (Book book : dupBooks) {
            System.out.println(book.getTitle());
        }
        System.out.println("-----------------------------------------------------------------------");

        // remove duplicates using a Set
        Collection<Book> noDups = new HashSet<>(dupBooks);
        System.out.println("After removing duplicates:");
        System.out.println("-----------------------------------------------------------------------");
        for (Book book : noDups) {
            System.out.println(book.getTitle());
        }
        System.out.println("-----------------------------------------------------------------------");

        // example of using Set to eliminate dups and sort automatically
        Set<Integer> numbers = new HashSet<>(asList(4, 3, 3, 3, 2, 1, 1, 1));
        System.out.println(numbers.toString());

    }
}
