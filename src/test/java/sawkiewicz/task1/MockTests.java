package sawkiewicz.task1;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


@RunWith(MockitoJUnitRunner.class)
public class MockTests {

    @Mock
    private ShoppingCartRepository shoppingCartRepository;

    @Mock
    private ItemRepository itemRepository;

//    @Captor
//    private ArgumentCaptor<ShoppingCart> cartArgumentCaptor;

    @InjectMocks
    private ShoppingCartService shoppingCartService;

    @Test
    public void shouldBePossibleToAddItemsToCart() throws Exception {
        when(shoppingCartRepository.findById("cartId")).thenReturn(new ShoppingCart("cartId", new LinkedList<>()));
        Item itemToTest = new Item("A", 40, 3, 70);
        shoppingCartService.addItemToCart("cartId", itemToTest);
        verify(shoppingCartRepository, times(2)).findById("cartId");
    }


//    @Test
//    public void shouldBePossibleToAddItemsToCart() throws Exception {
//        when(shoppingCartRepository.findById("cartId")).thenReturn(new ShoppingCart("cartId", new LinkedList<>()));
//
//        Item itemToTest = new Item("A", 40, 3, 70);
//        shoppingCartService.addItemToCart("cartId", itemToTest);
//        verify(shoppingCartRepository,times(2)).findById("cartId");

//        verify(shoppingCartRepository).add(cartArgumentCaptor.capture());
//        ShoppingCart value = cartArgumentCaptor.getValue();
//        Assert.assertEquals(value.getId(), "myId");
//    }




//    @Test
//    public void addItemToEmptyCart() {
//        List<CartItem> cartItems = new ArrayList<>();
//        String cartId = "testCart";
//        ShoppingCart testCart = new ShoppingCart(cartId, cartItems);
//        shoppingCartRepository.add(testCart);
//
//        Item itemToTest = new Item("A", 40, 3, 70);
//        CartItem cartItemToTest = new CartItem(1, itemToTest);
//
//        cartItems.add(cartItemToTest);
//        when(cartItems.get(0)).thenReturn(cartItemToTest);
//        shoppingCartService.addItemToCart(cartId, itemToTest);

//        when(testCart.getCartItems().get(0).getQuantity()).thenReturn(1);

//        Mockito.doNothing().when(shoppingCartService.addItemToCart(cartId, itemToTest));
//        when(shoppingCartRepository.findById("testCart")).thenReturn(testCart);
//    }
}
