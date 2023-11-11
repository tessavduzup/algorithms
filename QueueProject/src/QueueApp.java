import java.time.LocalDateTime;
import java.util.Random;

public class QueueApp {
    public static void main(String[] args) {
        System.out.println("Моделирование 1-й очереди:");
        double workTime1 = OneQueue();
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("Моделирование 2-х очередей:");
        double workTime2 = TwoQueue();
        System.out.println("\nДве очереди быстрее одной на " + (workTime1 - workTime2)/workTime2*100 + " процентов");
    }
    static double OneQueue() {
        Random random = new Random();
        int year = 2023;
        int month = 10;
        int day = 1;
        int hour = 1;
        int minute = 0;
        int second = 0;

        Queue queue = new Queue();
        double timeInQALL = 0;  // Общее время в очереди (в секундах)
        double workTime = 0;

        for (int i = 0; i <= 1000; i++) {
            if (i % 100 == 0 && i > 0) {
                System.out.println("Кол-во заявок в очереди: " + queue.OneQueueLength());
                System.out.println("Среднее время пребывания заявки в очереди: "
                                   + timeInQALL/queue.endedApplication + " секунд\n");
            }
            double interval = random.nextDouble(20, 200); // Интервал между заявками

            LocalDateTime time_in = LocalDateTime.of(year, month, day, hour, minute, second);

            int timeInQ = random.nextInt(60, 300); // Время в очереди 1 заявки (в секундах)
            second += timeInQ;

            // Блок условий на проверку корректности отображения времени
            if (second > 59) {
                minute += second / 60;
                second = second % 60;
            }
            if (minute > 59) {
                hour += minute / 60;
                minute = minute % 60;
            }
            if (hour > 23) {
                day += 1;
                hour = hour % 24;
            }
            if (day > 30) {
                month += 1;
                day = 1;
            }
            if (month > 12) {
                year += 1;
                month = 1;
            }

            double timeInOA = random.nextDouble(30, 250); // Время обработки заявки в терминале

            queue.pop_front(); // Выход заявки из очереди
            LocalDateTime time_out = LocalDateTime.of(year, month, day, hour, minute, second);

            queue.push_back(i, time_in, time_out);

            timeInQALL += timeInQ;

            workTime += timeInOA + interval;

            queue.endedApplication++;
        }
        System.out.println("Общее время моделирования: " + workTime + " секунд"); // Общее время моделирования в секундах
        return workTime;
    }
    static double TwoQueue() {
        Random random = new Random();

        int year = 2023;
        int month = 10;
        int day = 1;
        int hour = 1;
        int minute = 0;
        int second = 0;

        Queue queue1 = new Queue();
        Queue queue2 = new Queue();

        double timeInQueue1 = 0; // Общее время в очереди 1 (в секундах)
        double timeInQueue2 = 0; // Общее время в очереди 2 (в секундах)
        double workTime1 = 0;
        double workTime2 = 0;

        for (int i = 0; i <= 1000; i++) {
            if (i % 100 == 0 && i > 0) {
                System.out.println("Очередь 1: Кол-во заявок в очереди: " + queue1.TwoQueueLength());
                System.out.println("Среднее время пребывания заявки в очереди 1: " + timeInQueue1/queue1.endedApplication + " секунд");
                System.out.println("Очередь 2: Кол-во заявок в очереди: " + queue2.TwoQueueLength());
                System.out.println("Среднее время пребывания заявки в очереди 2: " + timeInQueue2/queue2.endedApplication + " секунд\n");
            }
            double interval = random.nextDouble(1, 260); // Интервал между заявками

            LocalDateTime timeIn = LocalDateTime.of(year, month, day, hour, minute, second);

            int timeInQueue = random.nextInt(60, 360); // Время в очереди 1 заявки (в секундах)
            second += timeInQueue;

            if (second > 59) {
                minute += second / 60;
                second = second % 60;
            }
            if (minute > 59) {
                hour += minute / 60;
                minute = minute % 60;
            }
            if (hour > 23) {
                day += 1;
                hour = hour % 24;
            }
            if (day > 30) {
                month += 1;
                day = 1;
            }
            if (month > 12) {
                year += 1;
                month = 1;
            }

            double timeInOA = random.nextDouble(60, 360); // Время обработки заявки
            if (queue1.TwoQueueLength() <= queue2.TwoQueueLength()) {
                queue1.push_back(i, timeIn, LocalDateTime.of(year, month, day, hour, minute, second));
                timeInQueue1 += timeInQueue;
                queue2.endedApplication++;
                workTime1 += interval + timeInOA;
            } else {
                queue2.push_back(i, timeIn, LocalDateTime.of(year, month, day, hour, minute, second));
                timeInQueue2 += timeInQueue;
                queue1.endedApplication++;
                workTime2 += interval + timeInOA;
            }
        }

        if (workTime1 > workTime2) {
            System.out.println("Общее время моделирования при 2-х очередях: " + workTime1 + " секунд"); // Общее время моделирования секундах
            return workTime1;
        }
        else {
            System.out.println("Общее время моделирования при 2-х очередях: " + workTime2 + " секунд"); // Общее время моделирования секундах
            return workTime2;
        }
    }
}