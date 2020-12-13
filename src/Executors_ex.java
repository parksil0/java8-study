import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Executors_ex {

    /*
     * 아래는 쓰레드의 기본적인 사용에 대해서 설명한다.
     * 아래의 예제는 쓰레드가 여러개가 쓰이다 보면 개발자는 설정에만 많은 곤란함을 느낄 수 있다.
     * 그 이유는 한 프로세스 내에서 여러개의 쓰레드가 각자 자신의 역할을 처리하고,
     * 그 역할에 대한 처리의 순서는 JVM이 아닌 OS가 처리하기 때문이다
     * 그래서 새로운 대안이 필요한데, 그것이 Executors 이다.
     * */
    public static void main(String[] args) {
    /*
        * newFixedThreadPool 은 몇 개의 쓰레드를 생성할지에 대해 설정할 수 있는 메서드이다.
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        * 아래의 submit 메서드를 통해 ThreadPool에서 어떻게 호출이 되는지를 알 수 있다.

        executorService.submit(getRunnable("A "));
        executorService.submit(getRunnable("B "));
        executorService.submit(getRunnable("C "));
        executorService.submit(getRunnable("D "));
        executorService.submit(getRunnable("E "));


        executorService.shutdown();
    */

        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.scheduleAtFixedRate(getRunnable("Hello"), 1, 2, TimeUnit.SECONDS);

        executorService.submit(() -> {
            System.out.println("Thread : " + Thread.currentThread().getName());
        });
    }
    private static Runnable getRunnable(String message) {
        return () -> System.out.println(message + Thread.currentThread().getName());
    }
}
