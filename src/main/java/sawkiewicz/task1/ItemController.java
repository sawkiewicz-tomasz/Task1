package sawkiewicz.task1;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
public class ItemController {
    ItemRepository itemRepository = new ItemRepository();
    ShoppingCartRepository shoppingCartRepository = new ShoppingCartRepository();



    @RequestMapping(method = RequestMethod.GET, value = "/total/{cartId}")
    ResponseEntity<String> showTotalPrice(@PathVariable String cartId) {
        return ResponseEntity.ok("Total price is: " + shoppingCartRepository.findById(cartId).calculateTotalCost());
    }

    @RequestMapping(method = RequestMethod.POST, value = "/cart/{cartId}/item")
    public ResponseEntity<String> addItem(@PathVariable String cartId, @RequestBody Item itemToAdd) {
        CartItem cartItemToAdd = new CartItem(1, itemToAdd);

        int sizeOfPurchase = shoppingCartRepository.findById(cartId).purchase.size();
        System.out.println(sizeOfPurchase);

        if (sizeOfPurchase == 0) {
            shoppingCartRepository.findById(cartId).purchase.add(cartItemToAdd);
        } else if (shoppingCartRepository.findById(cartId).purchase.contains(cartItemToAdd)) {
            for (CartItem cartItem : shoppingCartRepository.findById(cartId).purchase) {
                if (cartItem.item.getId().equals(itemToAdd.getId())) {
                    int temp = cartItem.getQuantity();
                    temp++;
                    cartItem.setQuantity(temp);
                }
            }
        } else {
            shoppingCartRepository.findById(cartId).purchase.add(cartItemToAdd);
        }

        return ResponseEntity.ok("Item " + itemToAdd.getId() + " added");
    }

    @RequestMapping(method = RequestMethod.POST, value = "/cart")
    public ResponseEntity<String> addCart(@RequestBody ShoppingCart cartToAdd) {
        shoppingCartRepository.add(cartToAdd);
        return ResponseEntity.ok("Cart " + cartToAdd.getId() + " added");
    }

    @RequestMapping(method = RequestMethod.GET, value = "/cart/{id}")
    public ShoppingCart showCart(@PathVariable String id) {
        return shoppingCartRepository.findById(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/items/{cartId}")
    List<CartItem> showTotalItems(@PathVariable String cartId) {
        return shoppingCartRepository.findById(cartId).purchase;
    }


}