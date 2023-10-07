package aspu;

import java.text.NumberFormat;

public class Item {
    private String name;
    private double price;
    private int quantity;

    // Конструктор для создания нового объекта
    public Item(String itemName, double itemPrice, int numPurchased) {
        name = itemName;
        price = itemPrice;
        quantity = numPurchased;
    }

    // Метод возвращает информацию о товаре
    public String toString() {
        NumberFormat fmt = NumberFormat.getCurrencyInstance();
        return (name + "\t " + fmt.format(price) + "\t\t" + quantity + "\t\t"
                + fmt.format(price * quantity));
    }

    // Метод возвращает цену одной единицы товара
    public double getPrice() {
        return price;
    }

    // Метод возвращает название товара
    public String getName() {
        return name;
    }

    // Возвращает количество товара
    public int getQuantity() {
        return quantity;
    }
}
