import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Optional_exam {
    public static void main(String[] args) {
        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(2, "spring data jpa", true));
        springClasses.add(new OnlineClass(3, "spring mvc", false));
        springClasses.add(new OnlineClass(4, "spring core", false));
        springClasses.add(new OnlineClass(5, "rest api development", false));

        OnlineClass spring_boot = new OnlineClass(1, "spring boot", true);

    /*
        컴파일 시 NPE 발생. 이유는 Progress라는 참조형 타입에 기본값은 null이기 때문.
        Duration studyDuration = spring_boot.getProgress().getStudyDuration();
        System.out.println(studyDuration);
    */
    /*
        객체 선언 후 if문을 통해 NPE 해결
        하지만 아래와 같은 if문을 통해 NPE를 벗어나는 방법은 에러를 만들기 좋은 코드이다.
        이유는 null을 체크하는 일을 깜빡할 수 있기 때문이다.
        Progress progress = spring_boot.getProgress();
        if(progress != null) {
            System.out.println(progress.getStudyDuration());
        }
    */

        Optional<OnlineClass> spring = springClasses.stream()
                .filter(c -> c.getTitle().startsWith("spring"))
                .findFirst();
/*
        get()메소드는 Optional안에 값이 있다면 값을 반환하지만,
        그렇지 않다면 NoSuchElementException을 반환한다.
        OnlineClass onlineClass = spring.get();
        System.out.println(onlineClass.getTitle());

        isPresent()는 현재 값이 있는지를 확인한다.(boolean type)
        boolean present = spring.isPresent();
        System.out.println(present);

        매개변수의 타입을 Consumer로 받는 ifPresent() 메서드로 아래와같이 작성할 수 있다.
        spring.ifPresent(c -> System.out.println(c.getTitle()));

*/
/*
        orElse()는 값이 있다면 값을 리턴하지만 없다면 매개변수를 실행한다.
        OnlineClass onlineClass1 = spring.orElse(createNewClass());

        orElseGet()은 orElse()와 차이점이라면 null이 아니여도 실행하는지에 대한 여부이다.
        orElseGet()은 값이 null이 아니라면 매개변수 안의 값을 실행시키지 않고,
        orElse()는 결과의 여부와 상관없이 실행된다.
        OnlineClass onlineClass2 = spring.orElseGet(Optional_exam::createNewClass);

        값이 있다면 실행하고 없다면 예외를 던진다.
        OnlineClass onlineClass3 = spring.orElseThrow(IllegalStateException::new);

        System.out.println(onlineClass1.getTitle());

        Optional<OnlineClass> onlineClass = spring.filter(c -> !c.isClosed());
        System.out.println(onlineClass.isPresent());

        Optional 안에 들어있는 인스턴스가 Optional인 경우에 사용하면 편리하다.
        Optional<Progress> progress = spring.flatMap(o -> o.getProgress());

        Optional<Optional<Progress>> progress1 = spring.map(c -> c.getProgress());
*/

    }

    private static OnlineClass createNewClass() {
        System.out.println("creating new online class");
        return new OnlineClass(10, "New Class", false);
    }
}


