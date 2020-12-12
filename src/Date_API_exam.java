import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class Date_API_exam {
    public static void main(String[] args) {
        //기계용
        Instant instant = Instant.now();
        System.out.println(instant); // 기준시 UTC, GMT
        System.out.println(instant.atZone(ZoneId.of("UTC"))); // 기준시 UTC

        ZoneId zone = ZoneId.systemDefault();
        System.out.println(zone);
        ZonedDateTime zonedDateTime = instant.atZone(ZoneId.systemDefault());
        System.out.println(zonedDateTime);

        //사람용
        LocalDateTime now = LocalDateTime.now();


        now.plus(10, ChronoUnit.DAYS);

        System.out.println("plus 10 : " + now);
        LocalDateTime myBirthday = LocalDateTime.of(1994, Month.JANUARY, 9, 0, 0, 0);
        System.out.println(myBirthday);
        ZonedDateTime nowInLogAngeles = ZonedDateTime.now(ZoneId.of("America/Los_Angeles"));
        System.out.println(nowInLogAngeles);

        Instant nowInstance = Instant.now();
        ZonedDateTime zonedDateTime2 = nowInstance.atZone(ZoneId.of("Asia/Seoul"));
        System.out.println(zonedDateTime);

        zonedDateTime2.toInstant();
        System.out.println(zonedDateTime2);

        //기간 표현 법
        LocalDate today = LocalDate.now();
        LocalDate christmas = LocalDate.of(2020, Month.DECEMBER, 25);
        Period period = Period.between(today, christmas);
        System.out.println(period.getDays());

        //사람용
        Period until = today.until(christmas);
        System.out.println(until.get(ChronoUnit.DAYS));

        //기계용
        Instant now2 = Instant.now();
        Instant plus = now2.plus(10, ChronoUnit.SECONDS);
        Duration between = Duration.between(now2, plus);
        System.out.println(between.getSeconds());

        //formatting
        LocalDateTime now3 = LocalDateTime.now();
        DateTimeFormatter MMddyyyy = DateTimeFormatter.ofPattern("MM?dd?yyyy");
        System.out.println(now3.format(MMddyyyy));

        LocalDate parse = LocalDate.parse("01?01?2000", MMddyyyy);
        System.out.println(parse);

        //API 간 호환이 가능
        Date date = new Date();
        Instant instant2 = date.toInstant();
        Date newDate = Date.from(instant2);

        GregorianCalendar gregorianCalendar =  new GregorianCalendar();
        ZonedDateTime dateTime = gregorianCalendar.toInstant().atZone(ZoneId.systemDefault());
        GregorianCalendar from = GregorianCalendar.from(dateTime);

        ZoneId zoneId = TimeZone.getTimeZone("PST").toZoneId();
        TimeZone timeZone = TimeZone.getTimeZone(zoneId);
    }
}
