package sawkiewicz.task1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Task1Configuration {

    @Bean
    public ShoppingCartRepository createShoppingCartRepository(){
        return new ShoppingCartRepository();
    }

    @Bean
    public ItemRepository createItemRepository(){
        return new ItemRepository();
    }

}

