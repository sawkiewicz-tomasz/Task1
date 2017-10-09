package sawkiewicz.task1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Task1ApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Test
    public void calculateTotalCost_0() {
        ShoppingCart testCart = new ShoppingCart();
        int expectedResult = 0;
        int result = testCart.calculateTotalCost();
        assertEquals(expectedResult, result, 0.01);
    }

    @Test
    public void calculateTotalCost_1_A_Item() {
        ItemRepository itemRepository = new ItemRepository();
        ShoppingCart testCart = new ShoppingCart();
        int expectedResult = 40;
        testCart.purchase.add(new CartItem(1, itemRepository.findById("A")));
        int result = testCart.calculateTotalCost();
        assertEquals(expectedResult, result, 0.01);
    }

    @Test
    public void calculateTotalCost_3_A_Item() {
        ItemRepository itemRepository = new ItemRepository();
        ShoppingCart testCart = new ShoppingCart();
        int expectedResult = 70;
        testCart.purchase.add(new CartItem(3, itemRepository.findById("A")));
        int result = testCart.calculateTotalCost();
        assertEquals(expectedResult, result, 0.01);
    }

    @Test
    public void getItemRepository() {
        List<Item> testItemList = ItemRepository.getItems();
        int expectedResult = 4;
        assertEquals(expectedResult, testItemList.size(), 0.01);
    }

    @Test
    public void findByName() {
        ItemRepository itemRepository = new ItemRepository();
        Item expectedItem = new Item("A", 40, 3, 70);
        Item resultItem = itemRepository.findById("A");
        assertTrue(expectedItem.equals(resultItem));
    }


}
