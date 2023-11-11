import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;

public class Main {

    public static void main(String[] args) {
        LocalDateTime toDateTime = LocalDateTime.of(2014, 9, 9, 19, 46, 45);
        LocalDateTime fromDateTime = LocalDateTime.of(1984, 12, 16, 7, 45, 55);

        Period period = Period.between(fromDateTime.toLocalDate(), toDateTime.toLocalDate());
        Duration duration = Duration.between(fromDateTime.toLocalTime(), toDateTime.toLocalTime());

        System.out.println(period.getYears() + " years " +
                period.getMonths() + " months " +
                period.getDays() + " days " +
                duration.toHoursPart() + " hours " +
                duration.toMinutesPart() + " minutes " +
                duration.toSecondsPart() + " seconds.");
    }
}
