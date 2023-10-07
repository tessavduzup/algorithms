package aspu;

import java.util.Objects;
import java.util.Scanner;

public class ShoppingCartApp {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        Scanner scan = new Scanner(System.in);

        int count = 0;
        System.out.println("Начинаем покупки");
        while(true) {
            if (count < cart.getCapacity()) {
                System.out.print("Введите название товара: ");
                String unit = scan.next();
                System.out.print("Введите цену товара: ");
                short price = scan.nextShort();
                System.out.print("Введите кол-во товара: ");
                short quantity = scan.nextShort();
                count++;

                cart.addToCart(unit, price, quantity);
                cart.CartOut();

                System.out.print("Продолжать покупки?(y/n): ");
                String choice = scan.next();

                if (Objects.equals(choice, "y")) {
                    System.out.println("Отлично!");
                } else break;
            }
            else {
                System.out.println("Корзина заполнена. Взять корзину побольше?(y/n)");
                String choice2 = scan.next();
                if (Objects.equals(choice2, "y")) {
                    cart.increaseSize();
                } else break;
            }
        }

        System.out.println("Пожалуйста, оплатите " + cart.toTotalPrice());
    }
}