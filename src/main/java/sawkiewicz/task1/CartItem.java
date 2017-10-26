package sawkiewicz.task1;

public class CartItem {
    private int quantity;
    private Item item;

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
        int temp = cartItem.quantity;
        temp++;
        cartItem.quantity = temp;
    }
}
