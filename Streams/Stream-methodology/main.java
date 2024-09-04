import java.util.*;
import java.util.stream.*;
import java.nio.file.*;
import java.io.IOException;

public class StreamExamples {

    public static void main(String[] args) {
        // 1. stream() - Creating a stream from a List
        List<String> words = Arrays.asList("apple", "banana", "cherry");
        Stream<String> streamFromList = words.stream();
        streamFromList.forEach(System.out::println);

        // 2. parallelStream() - Creating a parallel stream from a List
        Stream<String> parallelStreamFromList = words.parallelStream();
        parallelStreamFromList.forEach(System.out::println);

        // 3. Stream.of() - Creating a stream from specified elements
        Stream<String> streamOfElements = Stream.of("apple", "banana", "cherry");
        streamOfElements.forEach(System.out::println);

        // 4. Stream.iterate() - Creating an infinite stream
        Stream<Integer> streamIterate = Stream.iterate(0, n -> n + 2).limit(5); // Limiting to first 5 elements
        streamIterate.forEach(System.out::println);

        // 5. Stream.generate() - Creating an infinite stream using a Supplier
        Stream<Double> streamGenerate = Stream.generate(Math::random).limit(5); // Limiting to first 5 elements
        streamGenerate.forEach(System.out::println);

        // 6. Stream.concat() - Combining two streams into one
        Stream<String> stream1 = Stream.of("apple", "banana");
        Stream<String> stream2 = Stream.of("cherry", "date");
        Stream<String> combinedStream = Stream.concat(stream1, stream2);
        combinedStream.forEach(System.out::println);

        // 7. Stream.builder() - Creating a stream using a builder
        Stream<String> streamBuilder = Stream.<String>builder()
                                             .add("apple")
                                             .add("banana")
                                             .add("cherry")
                                             .build();
        streamBuilder.forEach(System.out::println);

        // 8. Arrays.stream() - Creating a stream from an array
        int[] numbers = {1, 2, 3, 4, 5};
        IntStream streamFromArray = Arrays.stream(numbers);
        streamFromArray.forEach(System.out::println);

        // 9. Stream.empty() - Creating an empty stream
        Stream<String> emptyStream = Stream.empty();
        System.out.println("Empty Stream has " + emptyStream.count() + " elements");

        // 10. Stream.ofNullable() - Creating a stream that handles nulls safely
        String word = null;
        Stream<String> nullableStream = Stream.ofNullable(word);
        System.out.println("Nullable Stream has " + nullableStream.count() + " elements");

        // 11. Files.lines() - Creating a stream from a file
        try (Stream<String> lines = Files.lines(Paths.get("example.txt"))) {
            lines.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 12. IntStream.range() and IntStream.rangeClosed() - Creating streams with a range of integers
        IntStream rangeStream = IntStream.range(1, 5); // 1, 2, 3, 4
        rangeStream.forEach(System.out::println);

        IntStream rangeClosedStream = IntStream.rangeClosed(1, 5); // 1, 2, 3, 4, 5
        rangeClosedStream.forEach(System.out::println);

        // 13. Stream.ofArray() - Creating a stream from an array
        String[] array = {"apple", "banana", "cherry"};
        Stream<String> streamFromArrayElements = Stream.of(array);
        streamFromArrayElements.forEach(System.out::println);
    }
}
