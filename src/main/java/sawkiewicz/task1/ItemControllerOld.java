
package sawkiewicz.task1;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
public class ItemControllerOld {

    List<Item> items = ItemRepositoryOld.getItems();

    @RequestMapping(method = RequestMethod.GET, value = "/items")
    ResponseEntity<String> showTotalPrice() {
        int totalPrice = 0;
        for (Item item : items) {
            totalPrice += item.calculateTotalPrice();
        }
        return ResponseEntity.ok("Total price is: " + totalPrice);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/items/{name}")
    public ResponseEntity<String> addItem(@PathVariable String name) {

        for (Item item : items) {
            if (item.getName().equals(name)) {
                int temp = item.getQuantity() + 1;
                item.setQuantity(temp);
            }
        }

        return ResponseEntity.ok("Item " + name + " added");

    }


}