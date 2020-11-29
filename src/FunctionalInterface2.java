

public class FunctionalInterface2 {
    public static void main(String[] args) {
        RunSomething2 run = new RunSomething2() {
            @Override
            public int plus10(int number) {
                System.out.println(number + 10);
                return number + 10;
            }
        };
        run.plus10(10);

        RunSomething2 run2 = (number) -> {
            System.out.println(number + 10);
            return number + 10;
        };
        run2.plus10(20);
    }
}

interface RunSomething2 {

    int plus10(int number);
}
