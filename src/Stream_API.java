import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Stream_API {
    public static void main(String[] args) {
        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(2, "spring data jpa", true));
        springClasses.add(new OnlineClass(3, "spring mvc", false));
        springClasses.add(new OnlineClass(4, "spring core", false));
        springClasses.add(new OnlineClass(5, "rest api development", false));



        System.out.println("spring 으로 시작하는 수업");
        springClasses.stream().filter(c -> c.getTitle().startsWith("spring"))
                .forEach(c -> System.out.println(c.getId()));


        //Predictate.not 이라는 static 메소드가 있지만 java8에는 없다.
        System.out.println("close 되지 않은 수업");
        springClasses.stream().filter(c -> c.isClosed())
                .forEach(c -> System.out.println(c.getId()));

        System.out.println("수업 이름만 모아서 스트림 만들기");
        springClasses.stream().map(c -> c.getTitle()).forEach(System.out::println);

        List<OnlineClass> javaClasses = new ArrayList<>();
        javaClasses.add(new OnlineClass(6, "The Java, Test", true));
        javaClasses.add(new OnlineClass(7, "The Java, Code manipulation", true));
        javaClasses.add(new OnlineClass(8, "The Java, 8 to 11", false));

        List<List<OnlineClass>> davidEvent = new ArrayList<>();
        davidEvent.add(springClasses);
        davidEvent.add(javaClasses);

        /*
        * flatmap 메서드는 list 안의 타입이 list인 경우
        * list 안에 있는 요소들을 모두 빼준다.(flatting)
        * */
        System.out.println("두 수업 목록에 들어있는 모든 수업 아이디 출력");
        davidEvent.stream().flatMap(onlineClasses -> onlineClasses.stream())
                .forEach(c -> System.out.println(c.getTitle()));

        System.out.println("10부터 1씩 증가하는 무제한 스트림 중에서 앞에 10개 빼고 최대 10개 까지만");
        Stream.iterate(10, i -> i + 1)
                .skip(10)
                .limit(10)
                .forEach(System.out::println);

        System.out.println("자바 수업 중에 Test가 들어있는 수업이 있는지 확인");
        System.out.println(
                javaClasses.stream()
                        .anyMatch(c -> c.getTitle()
                                .contains("Test")));


        System.out.println("스프링 수업 중에 제목이 spring이 들어간 것만 모아서 List로 만들기");
        //1
        List<String> spring = springClasses.stream()
                .filter(c -> c.getTitle().contains("spring"))
                .map(OnlineClass::getTitle)
                .collect(Collectors.toList());
        spring.forEach(System.out::println);

        //2
        List<String> spring1 = springClasses.stream().map(OnlineClass::getTitle)
                .filter(t -> t.contains("spring"))
                .collect(Collectors.toList());
        spring1.forEach(System.out::println);

    }
}

class OnlineClass {

    private Integer id;
    private String title;
    private boolean closed;
    public Progress progress;

    public OnlineClass(int id, String title, boolean closed) {
        this.id = id;
        this.title = title;
        this.closed = closed;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isClosed() {
        return closed;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }

    //get() 메소드의 반환값을 Optional로 감싸주면, 자연스럽게 null-safe한 코드가 된다.
    //Optional.ofNullable() 메소드는 null값일 때 NPE를 발생시키지 않고, null값일 때 값을 반환한다.
    public Optional<Progress> getProgress() {
        return Optional.ofNullable(progress);
    }

    public void setProgress(Progress progress) {
        this.progress = progress;
    }
}

class Progress {
    private Duration studyDuration;
    private boolean finished;

    public Duration getStudyDuration() {
        return studyDuration;
    }

    public void setStudyDuration(Duration studyDuration) {
        this.studyDuration = studyDuration;
    }
}
