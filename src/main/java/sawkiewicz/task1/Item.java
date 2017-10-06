package sawkiewicz.task1;

public class Item {
    private String name;
    private int price;
    private int specialUnitNumber;
    private int specialPrice;

    public Item(String name, int price, int specialUnitNumber, int specialPrice) {
        this.name = name;
        this.price = price;
        this.specialUnitNumber = specialUnitNumber;
        this.specialPrice = specialPrice;
    }

    public int getPrice() {
        return price;
    }

    public int getSpecialUnitNumber() {
        return specialUnitNumber;
    }

    public int getSpecialPrice() {
        return specialPrice;
    }

    public String getName() {
        return name;
    }


}
