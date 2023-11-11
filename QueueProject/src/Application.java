import java.time.LocalDateTime;

public class Application {
    int id;
    LocalDateTime time_in;
    LocalDateTime time_out;
    Application prev;
    Application next;
    Application(int id, LocalDateTime time_in, LocalDateTime time_out) {
        this.id = id;
        this.time_in = time_in;
        this.time_out = time_out;
        this.prev = this.next = null;
    }
}
