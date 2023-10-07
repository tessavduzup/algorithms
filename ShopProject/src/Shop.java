import java.util.ArrayList;

public class Shop {
    private ArrayList<Item> arriving;

    Shop() {
        this.arriving = new ArrayList<>(10);
    }

    public void addItem(String name, int price, String date, int count, int id) {
        this.arriving.add(new Item(name, price, date, count, id));
    }

    public void ArrayOut() {
        System.out.println("Поставки:");
        String result = "";
    for (Item i : arriving) {
        result += i + "\n";
    }
        System.out.println(result);
    }

    public void DeleteElementByID(int id) {
        arriving.removeIf(i -> i.getID() == id);
        System.out.println("Удалён элемент с id " + id + "\n");
    }

    public void arrivingSum(String name) { // Сумма товаров name
        int quantity = 0;
        short count = 0;
        int price = 0;
        for (Item i : arriving) {
            if (i.getName().equals(name)) {
                quantity += i.getCount();
                price = i.getPrice();
                count++;
            }
        }
        if (count > 0) {
            System.out.println("\nОбщая стоимость " + name + ": " + price * quantity * 0.13);
        }
        else {
            System.out.println("Такого товара нет");
        }
    }
    public void arrivedUnits(String date) {
        System.out.println("Товары, прибывшие " + date + ":");
        for (Item i : arriving) {
            if (i.getArrivingDate().equals(date)) {
                System.out.println(i.getName());
            }
        }
    }
}