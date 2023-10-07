package aspu;

import java.util.ArrayList;
import java.util.Scanner;

public class Shop {
    public static void main(String[] args) {
        ArrayList<Item> cart = new ArrayList<>();

        Item item;
        String itemName;
        double itemPrice;
        int quantity;
        Scanner scan = new Scanner(System.in);
        String keepShopping = "y";
        int resultPrice = 0;
        do {
            System.out.print("Введите название товара: ");
            itemName = scan.nextLine();
            System.out.print("Введите цену за единицу: ");
            itemPrice = scan.nextDouble();
            System.out.print("Введите количество: ");
            quantity = scan.nextInt();
            cart.add(new Item(itemName, itemPrice, quantity));
            for (Item i : cart) {
                System.out.println(i);
                resultPrice += i.getPrice() * i.getQuantity();
            }

            System.out.println("Продолжать покупки (y/n)? ");
            keepShopping = scan.nextLine();
        }
        while (keepShopping.equals("y"));
        System.out.println("Общая стоимость: " + resultPrice);
    }
}
