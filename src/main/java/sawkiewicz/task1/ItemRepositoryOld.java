package sawkiewicz.task1;

import java.util.ArrayList;
import java.util.List;

public class ItemRepositoryOld {

    private static List<Item> items = new ArrayList<>();

    static {
        items.add(new Item("A", 0, 40, 3, 70));
        items.add(new Item("B", 0, 10, 2, 15));
        items.add(new Item("C", 0, 30, 4, 60));
        items.add(new Item("D", 0, 25, 2, 40));
    }

    public static List<Item> getItems() {
        return items;
    }


}
