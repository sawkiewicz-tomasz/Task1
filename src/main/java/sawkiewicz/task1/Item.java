package sawkiewicz.task1;

public class Item {
    private String id;
    private int price;
    private int threshold;
    private int specialPrice;

    public Item() {
    }

    public Item(String id, int price, int threshold, int specialPrice) {
        this.id = id;
        this.price = price;
        this.threshold = threshold;
        this.specialPrice = specialPrice;
    }

    public int getPrice() {
        return price;
    }

    public int getThreshold() {
        return threshold;
    }

    public int getSpecialPrice() {
        return specialPrice;
    }

    public String getId() {
        return id;
    }

    public boolean isSameAs(Item item) {
        if (this == item) return true;
        if (price != item.price) return false;
        if (threshold != item.threshold) return false;
        if (specialPrice != item.specialPrice) return false;
        return id.equals(item.id);
    }

    @Override
    public String toString() {
        return "Item{" +
                "id='" + id + '\'' +
                ", price=" + price +
                ", threshold=" + threshold +
                ", specialPrice=" + specialPrice +
                '}';
    }
}
