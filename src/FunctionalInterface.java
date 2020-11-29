
public class FunctionalInterface {
    public static void main(String[] args) {

        // 익명 내부 클래스 anonymous inner class
        RunSomething run = new RunSomething() {
            @Override
            public void print() {
                System.out.println("hi!");
            }
        };
        run.print();

        // 람다식
        RunSomething run2 = () -> System.out.println("hi!!");
        run2.print();
    }
}

interface RunSomething {

    void print();
}
