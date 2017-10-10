package sawkiewicz.task1;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class Task1Controller {
    ItemRepository itemRepository = new ItemRepository();
    ShoppingCartRepository shoppingCartRepository = new ShoppingCartRepository();

    @RequestMapping(method = RequestMethod.GET, value = "/carts/{cartId}/price")
    ResponseEntity<String> showTotalPrice(@PathVariable String cartId) {
        return ResponseEntity.ok("Total price is: " + shoppingCartRepository.findById(cartId).calculateTotalCost());
    }

    @RequestMapping(method = RequestMethod.POST, value = "/carts/{cartId}/items")
    public ResponseEntity<String> addItem(@PathVariable String cartId, @RequestBody Item itemToAdd) {
        CartItem cartItemToAdd = new CartItem(1, itemToAdd);
        int sizeOfPurchase = shoppingCartRepository
                                .findById(cartId)
                                .getCartItems()
                                .size();

        if (sizeOfPurchase == 0) {
            shoppingCartRepository
                    .findById(cartId)
                    .getCartItems()
                    .add(cartItemToAdd);

            return ResponseEntity.ok("Item " + itemToAdd.getId() + " added");
        }

        for (CartItem cartItem : shoppingCartRepository.findById(cartId).getCartItems()) {
            if (cartItem.getItem().getId().equals(itemToAdd.getId())) {
                cartItem.increaseQuantiy(cartItem);
                return ResponseEntity.ok("Item " + itemToAdd.getId() + " added");
            }
        }

        shoppingCartRepository.findById(cartId).getCartItems().add(cartItemToAdd);
        return ResponseEntity.ok("Item " + itemToAdd.getId() + " added");
    }


    @RequestMapping(method = RequestMethod.POST, value = "/carts")
    public ResponseEntity<String> addCart(@RequestBody ShoppingCart cartToAdd) {
        shoppingCartRepository.add(cartToAdd);
        return ResponseEntity.ok("Cart " + cartToAdd.getId() + " added");
    }

    @RequestMapping(method = RequestMethod.GET, value = "/carts/{cartId}")
    public ShoppingCart showCart(@PathVariable String cartId) {
        return shoppingCartRepository.findById(cartId);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/carts/{cartId}/items")
    List<CartItem> showTotalItems(@PathVariable String cartId) {
        return shoppingCartRepository.findById(cartId).getCartItems();
    }
}