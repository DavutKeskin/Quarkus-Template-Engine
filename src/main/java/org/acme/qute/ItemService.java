package org.acme.qute;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ItemService {

    private Map<Integer, Item> items = new HashMap<Integer, Item>() {{
        put(1, new Item(new BigDecimal(1.99), "Apple"));
        put(2, new Item(new BigDecimal(2.99), "Pear"));
        put(3, new Item(new BigDecimal(3.99), "Grape"));
        put(4, new Item(new BigDecimal(129.99), "Mango"));
    }};

    public Item findItem(int id) {
        return items.get(id);
    }
}
