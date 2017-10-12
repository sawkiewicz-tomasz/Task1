package sawkiewicz.task1;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Task1Controller {
    ItemRepository itemRepository = new ItemRepository();
    ShoppingCartRepository shoppingCartRepository = new ShoppingCartRepository();
    ShoppingCartService shoppingCartService = new ShoppingCartService(shoppingCartRepository);

    @RequestMapping(method = RequestMethod.GET, value = "/carts/{cartId}/price")
    public ResponseEntity<Answer>showTotalPrice(@PathVariable String cartId) {
        Answer answer = shoppingCartService.showPrice(cartId);
        return ResponseEntity.ok(answer);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/carts/{cartId}/items")
    public ResponseEntity<Answer> addItem(@PathVariable String cartId, @RequestBody Item itemToAdd) {
        shoppingCartService.addItemToCart(cartId, itemToAdd);
        Answer answer = new Answer("ok", "Item added");
        return ResponseEntity.ok(answer);
    }


    @RequestMapping(method = RequestMethod.POST, value = "/carts")
    public ResponseEntity<Answer> addCart(@RequestBody ShoppingCart cartToAdd) {
        shoppingCartRepository.add(cartToAdd);
        Answer answer = new Answer("ok","Cart added");
        return ResponseEntity.ok(answer);
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