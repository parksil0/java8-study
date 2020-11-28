import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class Method_Reference {
    /*
    *  콜론이 두 번 찍혀있으면 reference이다.
    *  자세한 내용은 강의자료 5번에 표로 정리되어있다.
    * */
    public static void main(String[] args) {


        // 스태틱 메소드 참조
        UnaryOperator<String> hi = Greeting::hi;
        System.out.println(hi.apply("person2"));

        // 특정 객체의 인스턴스 메소드 참조
        Greeting greeting = new Greeting();
        UnaryOperator<String> hello = greeting::hello;
        System.out.println(hello.apply("person1"));

        //생성자 참조
        Supplier<Greeting> newGreeting1 = Greeting::new;
        newGreeting1.get();

        Function<String, Greeting> personGreeting
                = Greeting::new;
        Greeting person = personGreeting.apply("person");
        System.out.println(person.getName());

        // 임의 객체의 인스턴스 메소드 참조
        String[] names = {"wonbin", "dongwon", "gosu"};
        Arrays.sort(names, String::compareToIgnoreCase);
        System.out.println(Arrays.toString(names));

    }
}

class Greeting {

    private String name;

    public Greeting() {
    }

    public Greeting(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String hello(String name) {
        return "hello " + name;
    }

    public static String hi(String name) {
        return "hi " + name;
    }
}
