package sawkiewicz.task1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartService {

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    @Autowired
    private ItemRepository itemRepository;

    public ShoppingCartService(ShoppingCartRepository shoppingCartRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
    }

    public void addItemToCart(String cartId, Item itemToAdd) {
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
//            return new Response("ok", "Item added to empy cart");
            return;
        }
        for (CartItem cartItem : shoppingCartRepository.findById(cartId).getCartItems()) {
            if (cartItem.getItem().getId().equals(itemToAdd.getId())) {
                cartItem.increaseQuantiy(cartItem);
//                return new Response("ok", "Item added to empy cart");
                return;
            }
        }
        shoppingCartRepository.findById(cartId).getCartItems().add(cartItemToAdd);
//        return new Response("ok", "Item added to empy cart");
    }

    public Response showPrice(String cartId) {
        int valueOfPurchase = shoppingCartRepository.findById(cartId).calculateTotalCost();
        return new Response("ok", "" + valueOfPurchase);
    }
}
