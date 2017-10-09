package sawkiewicz.task1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;

import static java.util.stream.Collectors.toCollection;

public class ShoppingCartRepository implements Repository{

    public List<ShoppingCart> shoppingCarts = new ArrayList<>();


    public void add(ShoppingCart cartToAdd){
        shoppingCarts.add(cartToAdd);
    }


    public List<ShoppingCart> getShoppingCarts(){
        return shoppingCarts;
    }

    @Override
    public ShoppingCart findById(String id) {

        return shoppingCarts.stream().filter(shoppingCart -> shoppingCart.getId().equals(id))
                .collect(toCollection(() -> new ArrayBlockingQueue<ShoppingCart>(1)))
                .poll();
    }
}
