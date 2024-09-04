import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        // Sample data
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<String> words = Arrays.asList("apple", "banana", "cherry", "date", "elderberry");

        // 1. filter(): Get even numbers
        List<Integer> evenNumbers = numbers.stream()
                                           .filter(n -> n % 2 == 0)
                                           .collect(Collectors.toList());
        System.out.println("Even Numbers: " + evenNumbers);

        // 2. map(): Convert words to uppercase
        List<String> uppercasedWords = words.stream()
                                            .map(String::toUpperCase)
                                            .collect(Collectors.toList());
        System.out.println("Uppercased Words: " + uppercasedWords);

        // 3. flatMap(): Flatten a list of lists
        List<List<String>> namesNested = Arrays.asList(
            Arrays.asList("John", "Jane"),
            Arrays.asList("Tom", "Jerry")
        );
        List<String> namesFlat = namesNested.stream()
                                            .flatMap(List::stream)
                                            .collect(Collectors.toList());
        System.out.println("Flattened Names: " + namesFlat);

        // 4. reduce(): Sum of numbers
        int sum = numbers.stream()
                         .reduce(0, Integer::sum);
        System.out.println("Sum of Numbers: " + sum);

        // 5. collect(): Join words with commas
        String concatenated = words.stream()
                                   .collect(Collectors.joining(", "));
        System.out.println("Concatenated Words: " + concatenated);

        // 6. sorted(): Sort words alphabetically
        List<String> sortedWords = words.stream()
                                        .sorted()
                                        .collect(Collectors.toList());
        System.out.println("Sorted Words: " + sortedWords);

        // 7. distinct(): Get distinct numbers
        List<Integer> distinctNumbers = Arrays.asList(1, 2, 2, 3, 4, 4, 5)
                                              .stream()
                                              .distinct()
                                              .collect(Collectors.toList());
        System.out.println("Distinct Numbers: " + distinctNumbers);

        // 8. limit(): Get first 3 numbers
        List<Integer> limitedNumbers = numbers.stream()
                                              .limit(3)
                                              .collect(Collectors.toList());
        System.out.println("Limited Numbers: " + limitedNumbers);

        // 9. skip(): Skip first 2 numbers
        List<Integer> skippedNumbers = numbers.stream()
                                              .skip(2)
                                              .collect(Collectors.toList());
        System.out.println("Skipped Numbers: " + skippedNumbers);

        // 10. forEach(): Print all words
        System.out.println("All Words:");
        words.stream().forEach(System.out::println);

        // 11. anyMatch(): Check if any number is even
        boolean hasEven = numbers.stream()
                                 .anyMatch(n -> n % 2 == 0);
        System.out.println("Has Even Numbers: " + hasEven);

        // 12. allMatch(): Check if all numbers are positive
        boolean allPositive = numbers.stream()
                                     .allMatch(n -> n > 0);
        System.out.println("All Positive Numbers: " + allPositive);

        // 13. noneMatch(): Check if no number is negative
        boolean noNegative = numbers.stream()
                                    .noneMatch(n -> n < 0);
        System.out.println("No Negative Numbers: " + noNegative);

        // 14. findFirst(): Get first word
        Optional<String> firstWord = words.stream()
                                          .findFirst();
        firstWord.ifPresent(word -> System.out.println("First Word: " + word));

        // 15. findAny(): Get any word
        Optional<String> anyWord = words.stream()
                                        .findAny();
        anyWord.ifPresent(word -> System.out.println("Any Word: " + word));

        // 16. count(): Count the number of words
        long count = words.stream()
                          .count();
        System.out.println("Number of Words: " + count);

        // 17. max(): Get max number
        Optional<Integer> maxNumber = numbers.stream()
                                             .max(Integer::compareTo);
        maxNumber.ifPresent(max -> System.out.println("Max Number: " + max));

        // 18. min(): Get min number
        Optional<Integer> minNumber = numbers.stream()
                                             .min(Integer::compareTo);
        minNumber.ifPresent(min -> System.out.println("Min Number: " + min));
    }
}
