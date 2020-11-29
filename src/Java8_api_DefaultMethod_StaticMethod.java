import java.util.*;

public class Java8_api_DefaultMethod_StaticMethod {

    public static void main(String[] args) {
        List<String> name = new ArrayList<>();
        name.add("wonbin");
        name.add("gosu");
        name.add("dongwon");

        name.forEach(System.out::println);
        System.out.println("---------------------------------");

        Spliterator<String> spliterator = name.spliterator();
        Spliterator<String> spliterator1 = spliterator.trySplit();
        while(spliterator.tryAdvance(System.out::println));
        System.out.println("---------------------------------");
        while(spliterator1.tryAdvance(System.out::println));
        System.out.println("---------------------------------");

        name.removeIf(s -> s.startsWith("g"));
        name.forEach(System.out::println);
        System.out.println("---------------------------------");

        Comparator<String> compareToIgnoreCase = String::compareToIgnoreCase;
        name.sort(compareToIgnoreCase.reversed());
        name.forEach(System.out::println);
    }

}
