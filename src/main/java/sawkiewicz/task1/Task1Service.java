package sawkiewicz.task1;

import org.springframework.stereotype.Service;


@Service
public class Task1Service {

    ShoppingCartRepository shoppingCartRepository;
//    ItemRepository itemRepository;

    public Task1Service(ShoppingCartRepository shoppingCartRepository) {//, ItemRepository itemRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
//        this.itemRepository = itemRepository;
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

}
