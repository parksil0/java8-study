
public class Concurrent_ex {

    public static void main(String[] args){
        MyThread myThread = new MyThread();
        myThread.start();

        //인터페이스로 구현하여 사용하는 방법
        Thread thread = new Thread(() -> {
            System.out.println("Thread interface : " + Thread.currentThread().getName());
            try {
                Thread.sleep(3 * 1000);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
        });
        thread.start();

        System.out.println("Hello : " + Thread.currentThread().getName());
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(thread + " is finished");
    }

    //쓰레드를 상속받아 사용하는 방법
    static class MyThread extends Thread {

        @Override
        public void run() {
            System.out.println("Thread class : " + Thread.currentThread().getName());
        }
    }
}
