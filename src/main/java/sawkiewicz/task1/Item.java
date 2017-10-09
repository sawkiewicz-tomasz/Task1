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

    public void setId(String id) {
        this.id = id;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setThreshold(int threshold) {
        this.threshold = threshold;
    }

    public void setSpecialPrice(int specialPrice) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;

        Item item = (Item) o;

        if (price != item.price) return false;
        if (threshold != item.threshold) return false;
        if (specialPrice != item.specialPrice) return false;
        return id.equals(item.id);
    }


}
