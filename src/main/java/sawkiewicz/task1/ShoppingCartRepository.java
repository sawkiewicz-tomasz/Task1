package sawkiewicz.task1;

import java.util.ArrayList;
import java.util.List;
import static java.util.stream.Collectors.toCollection;

public class ShoppingCartRepository implements Repository<String,ShoppingCart> {

    public List<ShoppingCart> shoppingCarts = new ArrayList<>();

    public void add(ShoppingCart cartToAdd) {
        shoppingCarts.add(cartToAdd);
    }

    @Override
    public ShoppingCart findById(String id) {
        return shoppingCarts.stream()
                .filter(shoppingCart -> shoppingCart.getId().equals(id))
                .collect(toCollection(ArrayList::new))
                .get(0);
    }
}
