import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class Stream {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("wonbin");
        names.add("gosu");
        names.add("woosung");

        //자바8에선 컴파일 오류가 발생한다.
        //Stream<String> stringStream = names.stream().map(String::toUpperCase)

        //마지막에 종료 오퍼레이션을 설정하지 않으면 실행되지 않는다.
    /*
        List<String> collect = names.stream().map(s -> {
            System.out.println(s);
            return s.toUpperCase();
        }).collect(Collectors.toList());
        collect.forEach(System.out::println);

        names.forEach(System.out::println);
    */

        /*
            병렬 처리
            스트림의 특징 중 하나로 손쉽게 병렬 처리를 할 수 있다.(parallelStream())
            하지만 병렬 처리는 데이터가 무수히 많은 경우에 유용하지,
            나머지의 경우에 사용할 때는 오히려 쓰레드를 만들고 할당하는 비용이
            더욱 손해인 경우도 있다.
        */
        List<String> collect1 = names.parallelStream().map(s -> {
            System.out.println(s + " " + Thread.currentThread().getName());
            return s.toUpperCase();
        }).collect(Collectors.toList());
        collect1.forEach(System.out::println);

    }
}
