import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Date_exam {
    public static void main(String[] args) throws InterruptedException {
//        SimpleDateFormat dateFormat = new SimpleDateFormat();

        //date.getTime() 메소드는 우리가 알고 있는 시간을 반환하지 않는다.
        //게다가 보통 Date 클래스는 날짜로만 생각 하는게 대부분인데, 시간을 반환하는 것도 어감이 좋지 않다.
        Date date = new Date();
        long time = date.getTime();

        System.out.println(date.toString());
        System.out.println(time);

        //Thread-safe 하지 않음(Date 는 mutable 하다)
        Thread.sleep(1000 * 3);
        Date after3Seconds = new Date();
        System.out.println("now time : " + after3Seconds);
        after3Seconds.setTime(time);
        System.out.println("3 seconds ago : " + after3Seconds);

        // Type-safe 하지 않음(매개변수의 타입이 int 이기 때문에 아무 값이나 들어갈 수 있기 때문이다.)
        // 가운데 월은 0부터 시작하기 때문에 헷갈릴 요소가 있다. 그러므로 상수화 된 변수를 사용하는 것을 추천한다.
        Calendar christmas = new GregorianCalendar(2020, Calendar.DECEMBER, 25);

        /*
        * 위의 getTime() 메소드는 long 타입이다.
        * 아래의 getTime() 메소드는 Date 타입인데, long 타입의 메소드는 1970년 1월 1일부터 현재 시간까지의
        * millisecond 를 반환한다. 그러므로 long 타입으로 시간을 계산하려면 또 다른 연산을 필요로한다.
        * 하지만 Date 타입의 메소드는 EEE MMM dd HH:mm:ss zzz yyyy 순으로 반환한다.
        * 그러므로 타입에 따른 반환값이 다르기 때문에 메소드를 호출할 때 주의해야 한다.
        * */
        System.out.println(christmas.getTime());

        // Calendar 클래스는 mutable 하기 때문에 값을 변경할 수 있다.
//        myBirthday.add(Calendar.DAY_OF_YEAR, 1);
//        System.out.println(myBirthday.toInstant());

    }
}
