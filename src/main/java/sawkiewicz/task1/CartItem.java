package sawkiewicz.task1;

public class CartItem {
    private int quantity;
    private Item item;

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public Item getItem() {
        return item;
    }

    public CartItem(int quantity, Item item) {
        this.quantity = quantity;
        this.item = item;
    }

    public CartItem() {
    }

    public void increaseQuantiy (CartItem cartItem){
        int temp = cartItem.getQuantity();
        temp++;
        cartItem.setQuantity(temp);
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "quantity=" + quantity +
                ", item=" + item +
                '}';
    }
}
