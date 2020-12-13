import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class Callable_Future_ex {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /* 이전에서는 쓰레드가 void 인 경우들만 다루었다.
         * 이는 리턴 타입이 없다는 뜻인데, 리턴타입을 받는 방법은 Callable, Future가 있다.
         */
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        Callable<String> hello = () -> {
            Thread.sleep(2000);
            return "Hello";
        };

        Callable<String> hi = () -> {
            Thread.sleep(1000);
            return "Hi";
        };

        Callable<String> java = () -> {
            Thread.sleep(3000);
            return "Java";
        };

        //아래는 invokeAll() 메서드로, 리스트에 담을 모든 값을이 리턴되면 담아 한번에 보여주는 과정이다
        List<Future<String>> futures = executorService.invokeAll(Arrays.asList(hello, hi, java));
        for(Future<String> f : futures) {
            System.out.println(f.get());
        }

        //아래는 invokeAny()로, 제일빨리 나오는 값을 리턴한다.
        String s = executorService.invokeAny(Arrays.asList(hello, hi, java));
        System.out.println(s);

    /*
        Future<String> HelloFuture = executorService.submit(hello);
        System.out.println(HelloFuture.isDone());
        System.out.println("Started!");

        //HelloFuture.get(); //blocking call
        현재 작업을 취소할지를 설정하는 메소드이다.
        cancel 메서드를 실행시키고나서 get 메소드를 호출하면 에러가 발생한다.
        그 이유는 이미 취소된 작업에 값을 요구했기 때문이다.
        cancel() 메서드의 매개변수가 true이든 false이든 상관없이 get()메소드를 실행시키면 오류가 발생한다.
        HelloFuture.cancel(false);
        //HelloFuture.get(); // 에러발생

        System.out.println(HelloFuture.isDone());
        System.out.println("End!");
        executorService.shutdown();
    */


    }
}
