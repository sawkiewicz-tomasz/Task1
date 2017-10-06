
package sawkiewicz.task1;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class ItemController {
    ItemRepository itemRepository = new ItemRepository();
    Client client = new Client();

    @RequestMapping(method = RequestMethod.GET, value = "/items")
    ResponseEntity<String> showTotalPrice() {
        return ResponseEntity.ok("Total price is: " + client.calculateTotalCost());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/items/{name}")
    public ResponseEntity<String> addItem(@PathVariable String name) {

        Item itemToAdd = itemRepository.findByName(name);

        if (client.shoppingChart.containsKey(itemToAdd)) {
            int temp = client.shoppingChart.get(itemToAdd) + 1;
            client.shoppingChart.put(itemToAdd, temp);
        } else {
            client.shoppingChart.put(itemToAdd, 1);
        }

        return ResponseEntity.ok("Item " + name + " added");
    }


}