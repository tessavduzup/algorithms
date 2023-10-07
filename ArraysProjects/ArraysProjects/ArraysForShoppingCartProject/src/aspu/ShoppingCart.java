package aspu;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class ShoppingCart {
    private int itemCount; // общее количество товаров в корзине
    private double totalPrice; // общая стоимость товаров в корзине
    private int capacity; // текущая вместимость тележки
    private ArrayList<Item> cart;
    Scanner scan = new Scanner(System.in);

    // Создает пустую корзину для покупок, вмещающую 5 товаров.
    public ShoppingCart() {
        this.capacity = 1;
        this.itemCount = 0;
        this.totalPrice = 0.0;
        this.cart = new ArrayList<>(capacity);
    }

    private String toRubles(double totalPrice) {
        NumberFormat fmt = NumberFormat.getCurrencyInstance();
        return fmt.format(totalPrice);
    }

    // добавляет товар в корзину.
    public void addToCart(String itemName, double price, int quantity) {
        // Добавить условие если корзина полная, то надо увеличить объем
        this.cart.add(new Item(itemName, price, quantity));
        this.totalPrice += price * quantity;
        this.itemCount++;
    }

    //Возвращает содержимое корзины вместе с итоговой информацией.
    public void CartOut() {
        String contents = "\nКорзина\n";
        contents += "\nItem\tUnit Price\tQuantity\tTotal\n";
        for (int i = 0; i < this.itemCount; i++){
            contents += this.cart.get(i) + "\n";
        }
        contents += "\nОбщая цена: " + this.toTotalPrice();
        contents += "\n";
        System.out.println(contents);
    }

    /// Увеличивает вместимость корзины на 3 позиции или
    /// на значение введённое с клавиатуры
    public void increaseSize() {
        System.out.print("Увеличить объём корзины на: ");
        short increase = scan.nextShort();
        ArrayList<Item> old_cart = new ArrayList<>(this.cart);
        this.capacity += increase;
        this.cart = new ArrayList<>(this.capacity);
        cart.addAll(old_cart);
        System.out.println("\nОбъём корзины увеличен!");
    }

    public String toTotalPrice() {
        return toRubles(totalPrice);
    }

    public int getCapacity() {
        return this.capacity;
    }
}