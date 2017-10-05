package sawkiewicz.task1;

import org.springframework.data.repository.Repository;

public interface ItemRepository extends Repository<Item> {

    Item findByName(String name);
    Item update(String name);



}
