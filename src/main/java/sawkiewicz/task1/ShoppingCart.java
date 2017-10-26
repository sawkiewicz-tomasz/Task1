package sawkiewicz.task1;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private String id;
    private List <CartItem> cartItems = new ArrayList<>();

    public ShoppingCart(String id, List<CartItem> cartItems) {
        this.id = id;
        this.cartItems = cartItems;
    }

    public ShoppingCart() {
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public String getId() {
        return id;
    }

    public int calculateTotalCost() {
        int totalCost = 0;
        for (CartItem cartItem: cartItems) {
            int quantity = cartItem.getQuantity();
            Item item = cartItem.getItem();
            totalCost += quantity / item.getThreshold() * item.getSpecialPrice() + quantity % item.getThreshold() * item.getPrice();
        }
        return totalCost;
    }
}
