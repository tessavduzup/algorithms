import java.time.LocalDateTime;

public class Queue {
    Application head;
    Application tail;
    int endedApplication;
    Queue() {
        this.head = this.tail = null;
        this.endedApplication = 0;
    }
    void push_back(int id, LocalDateTime time_in, LocalDateTime time_out) {
        Application node = new Application(id, time_in, time_out);

        if (this.head != null)
        {
            this.head.prev = node;
        }
        if (this.tail == null) {
            this.tail = node;
        }
        this.head = node;
    }

    void pop_front() {
        if (this.head == null) return;

        Application node = this.head.next;
        if (node != null) {
            node.prev = null;
        }
        else this.tail = null;

        this.head = node;
    }

    Application getFront() {
        return this.head;
    }

    int OneQueueLength() {
        return 1000 - this.endedApplication;
    }
    int TwoQueueLength() {
        return 500 - this.endedApplication;
    }
}