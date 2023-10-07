package aspu;
import java.util.Scanner;

public class Sales {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите нужное кол-во продавцов: ");
        final int salesPeople = scan.nextInt();
        int[] sales = new int[salesPeople];
        int sum;

        for (int i = 1; i < sales.length + 1; i++) {
            System.out.print("Введите объем продаж для продавца " + i + ": ");
            sales[i-1] = scan.nextInt();
        }

        System.out.println("\nПродажи продавца");
        System.out.println("--------------------");

        sum = 0;
        int max = sales[0];
        int max_saler = 1;
        int min = sales[0];
        int min_saler = 1;
        for (int i = 1; i < sales.length + 1; i++) {
            System.out.println(" " + i + " " + sales[i - 1]);
            sum += sales[i - 1];

            if (max < sales[i - 1]) {
                max = sales[i - 1];
                max_saler = i;
            }

            if (min > sales[i - 1]) {
                min = sales[i - 1];
                min_saler = i;
            }
        }

        System.out.println("\nОбщие продажи: " + sum);
        System.out.println("Средний объём продаж: " + (double)sum/salesPeople);
        System.out.println("\nПродавец " + max_saler + " совершил самую большую продажу на " + max + toRUB(max));
        System.out.println("Продавец " + min_saler + " совершил самую маленькую продажу на " + min + toRUB(min));

        System.out.println("Введите любое значение: ");
        int var = scan.nextInt();
        System.out.println("\nПродавцы, превысившие план продаж: ");

        int index = 1;
        short count = 0;
        for (int i : sales) {
            if (i > var) {
                System.out.println(index + " " + i);
                count++;
            }
            index++;
        }
        System.out.println("Итого: " + count);
    }

    private static String toRUB(int rubles) {
        if (rubles % 10 == 1) {
            return " рубль\n";
        }
        else if (rubles % 10 == 2 || rubles % 10 == 3 || rubles % 10 == 4) {
            return " рубля\n";
        }
        else {
            return " рублей\n";
        }
    }
}