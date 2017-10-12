package sawkiewicz.task1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ShoppingCartService {

    @Autowired
    ShoppingCartRepository shoppingCartRepository;

    @Autowired
    ItemRepository itemRepository;

    public ShoppingCartService(ShoppingCartRepository shoppingCartRepository) {//, ItemRepository itemRepository) {
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
            return;
        }
        for (CartItem cartItem : shoppingCartRepository.findById(cartId).getCartItems()) {
            if (cartItem.getItem().getId().equals(itemToAdd.getId())) {
                cartItem.increaseQuantiy(cartItem);
                return;
            }
        }
        shoppingCartRepository.findById(cartId).getCartItems().add(cartItemToAdd);
    }

    public Answer showPrice(String cartId) {
        Answer answer = new Answer();
        int valueOfPurchase = shoppingCartRepository.findById(cartId).calculateTotalCost();
        answer.setResponce("ok");
        answer.setMessage("" + valueOfPurchase);
        return answer;
    }
}
