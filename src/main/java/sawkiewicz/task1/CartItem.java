package sawkiewicz.task1;

public class CartItem {
    int quantity;
    Item item;

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public CartItem(int quantity, Item item) {
        this.quantity = quantity;
        this.item = item;
    }

    public CartItem() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CartItem)) return false;

        CartItem cartItem = (CartItem) o;

        if (quantity != cartItem.quantity) return false;
        return item != null ? item.equals(cartItem.item) : cartItem.item == null;
    }

}
