package sawkiewicz.task1;

import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;
import static java.util.stream.Collectors.toCollection;

public class ItemRepository implements Repository {
    private static List<Item> items = new ArrayList<>();

    static {
        items.add(new Item("A", 40, 3, 70));
        items.add(new Item("B", 10, 2, 15));
        items.add(new Item("C", 30, 4, 60));
        items.add(new Item("D", 25, 2, 40));
    }

    public static List<Item> getItems() {
        return ImmutableList.copyOf(items);
    }

    @Override
    public Item findById(String id) {
        return items.stream()
                .filter(item -> item.getId().equals(id))
                .collect(toCollection(ArrayList::new))
                .get(0);
    }
}


