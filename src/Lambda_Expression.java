import java.util.function.Consumer;
import java.util.function.IntConsumer;

public class Lambda_Expression {
    public static void main(String[] args) {
        Lambda_Expression test = new Lambda_Expression();
        test.run();
    }

    /*
    *  로컬 클래스, 익명 클래스, 람다 총 세개의 식이 있다.
    *  세 개의 공통점은 모두 변수를 참조할 수 있다.
    *  자바 8부터는 final을 생략할 수 있는 경우가 있다.(effective final)
    *  이 변수를 어디에서도 변경 하지 않는 경우 compiler가 final이라고 판단한다.
    *
    *  차이점이라면 shadowing(가려짐)의 차이이다.
    *  람다를 제외한 로컬과 익명 클래스는 shadowing이 적용된다.
    *
    *  로컬클래스와 익명클래스는 다른 scope에 존재하기 때문에 해당 scope안에 정의된 변수의 이름이 같다면
    *  해당 scope안에 있는 변수가 적용이 된다.(shadowing)
    *
    *  하지만 람다는 run()과 같은 scope에 있기 때문에 같은 타입과 변수명이 중복되면 안된다.
    *  즉, 에러가 발생한다.
    *
    *  또한 필드에 선언되어있는 변수 baseNumber의 변수가 effective final이 적용되지 않는다면,
    *  람다식에서 사용 할 수 없다.
    *
    *  ** 익명클래스가 final 변수만 참조 가능한 이유
    *  여기서 익명클래스의 인스턴스로 넘겨지는 모든 변수들은 final이어야 한다.
    *  익명 클래스의 인스턴스가 필요로 하는 변수 정보나 컨텍스트를 복사해서 넘겨주기 때문이다.
    *  이런 상황에서 변수가 변경되면 의도치 않은 결과가 나올 수 있으므로 변경되지 않도록
    *  final로 선언 되어야만 하고, 그렇지 않은 경우 컴파일 에러가 발생한다.
    *
    *  자료참조(https://futurecreator.github.io/2018/08/02/java-lambda-variable-scope/)
    * */
    private void run() {
        int baseNumber = 10;

        // 로컬 클래스
        class localClass {
            void printBaseNumber() {
                int baseNumber = 11;
                System.out.println(baseNumber); // 11
            }
        }

        // 익명 클래스
        Consumer<Integer> integerConsumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer BaseNumber) {
                System.out.println(baseNumber);
            }
        };

        // 람다
        IntConsumer printInt = (i) -> {
            System.out.println(i + baseNumber);
        };
    }
}
