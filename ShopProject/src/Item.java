import java.text.NumberFormat;

public class Item {
    private String Name;
    private int Price;
    private String ArrivingDate;
    private int count;
    private int id;

    Item(String Name, int Price, String ArrivingDate, int count, int id) {
        this.Name = Name;
        this.Price = Price;
        this.ArrivingDate = ArrivingDate;
        this.count = count;
        this.id = id;
    }

    public int getID() {
        return this.id;
    }
    public int getPrice() {
        return this.Price;
    }
    public int getCount() {
        return this.count;
    }
    public String getArrivingDate() {
        return this.ArrivingDate;
    }
    public String getName() {
        return this.Name;
    }
    public String toString() {
        NumberFormat fmt = NumberFormat.getCurrencyInstance();
        return (Name + "\t " + fmt.format(Price) + "\t\t" + ArrivingDate + "\t\t"
                + count + id);
    }
}