package sawkiewicz.task1;

import java.util.HashMap;
import java.util.Map;

public class Client {
    String name;
    Map<Item, Integer> shoppingChart = new HashMap<>();

    public Client() {
    }

    public int calculateTotalCost() {
        int totalCost = 0;

        for (Map.Entry<Item, Integer> itemOrder : shoppingChart.entrySet()) {
            int quantity = itemOrder.getValue();
            Item item = itemOrder.getKey();

            totalCost += quantity / item.getSpecialUnitNumber() * item.getSpecialPrice() + quantity % item.getSpecialUnitNumber() * item.getPrice();
        }

        return totalCost;
    }


}
