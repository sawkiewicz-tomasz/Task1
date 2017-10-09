package sawkiewicz.task1;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    String id;
    List <CartItem> purchase = new ArrayList<>();

    public ShoppingCart() {
    }

    public ShoppingCart(String id) {
        this.id = id;
    }

    public ShoppingCart(String id, List<CartItem> purchase) {
        this.id = id;
        this.purchase = purchase;
    }

    public String getId() {
        return id;
    }

    public int calculateTotalCost() {
        int totalCost = 0;

        for (CartItem cartItem: purchase) {

            int quantity = cartItem.quantity;
            Item item = cartItem.item;

            totalCost += quantity / item.getThreshold() * item.getSpecialPrice() + quantity % item.getThreshold() * item.getPrice();
        }

        return totalCost;
    }


}
