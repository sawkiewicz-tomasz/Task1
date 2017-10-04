
package sawkiewicz.task1;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Controller
public class ItemController {
    Map<Character, Integer> items = new HashMap<>();

    @PostConstruct
    public void init() {
        items.put('A', 0);
        items.put('B', 0);
        items.put('C', 0);
        items.put('D', 0);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/items")
    @ResponseBody
    public Map<Character, Integer> getAllItems() {
        return items;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/totalprice")
    @ResponseBody
    ResponseEntity<String> getTotalPrice() {
        int totalPrice = 0;
        Item itemA = new Item('A', items.get('A'));
        Item itemB = new Item('B', items.get('B'));
        Item itemC = new Item('C', items.get('C'));
        Item itemD = new Item('D', items.get('D'));
        totalPrice = itemA.giveTotalPrice() + itemB.giveTotalPrice() + itemC.giveTotalPrice() + itemD.giveTotalPrice();
        return ResponseEntity.ok("Total price is: " + totalPrice);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/additem/{id}")
    @ResponseBody
    public ResponseEntity<String> uaddItem(@PathVariable char id) {

        if (items.containsKey(id)) {

            int temp = items.get(id);
            temp++;
            items.put(id,temp);

            return ResponseEntity.ok("Item " + id + " added");
        } else {

            return ResponseEntity.ok("No such item in database");
        }

    }

}