package sawkiewicz.task1;

public class Item {
    private String name;
    private int quantity;
    private int price;
    private int specialUnitNumber;
    private int specialPrice;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Item(String name, int quantity, int price, int specialUnitNumber, int specialPrice) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.specialUnitNumber = specialUnitNumber;
        this.specialPrice = specialPrice;
    }

    public String getName() {
        return name;
    }

    public int calculateTotalPrice() {
        return quantity / specialUnitNumber * specialPrice + quantity % specialUnitNumber * price;
    }

}
