package sawkiewicz.task1;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class Task1Controller {
    private ItemRepository itemRepository = new ItemRepository();
    private ShoppingCartRepository shoppingCartRepository = new ShoppingCartRepository();
    private ShoppingCartService shoppingCartService = new ShoppingCartService(shoppingCartRepository);

    @RequestMapping(method = RequestMethod.GET, value = "/carts/{cartId}/price")
    public Response showTotalPrice(@PathVariable String cartId) {
        return shoppingCartService.showPrice(cartId);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/carts/{cartId}/items")
    public Response addItem(@PathVariable String cartId, @RequestBody Item itemToAdd) {
        shoppingCartService.addItemToCart(cartId, itemToAdd);
        return new Response("ok", "Item added");
    }

    @RequestMapping(method = RequestMethod.POST, value = "/carts")
    public Response addCart(@RequestBody ShoppingCart cartToAdd) {
        shoppingCartRepository.add(cartToAdd);
        return new Response("ok", "Cart added");
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