public class Main {
    public static void main(String[] args) {
        Shop shop = new Shop();

        shop.addItem("Хлеб", 25, "2023-03-03", 5, 1);
        shop.addItem("Мыло", 34, "2023-03-03", 10, 2);
        shop.addItem("Корм", 150, "2023-03-10", 2, 3);
        shop.addItem("Мыло", 34, "2023-03-10", 10, 4);

        shop.ArrayOut();
        shop.arrivedUnits("2023-03-03");
        shop.arrivingSum("Мыло");

        shop.DeleteElementByID(2);
        shop.ArrayOut();
    }

}