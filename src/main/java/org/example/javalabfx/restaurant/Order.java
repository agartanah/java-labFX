package org.example.javalabfx.restaurant;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Order {
    private final Map<Dish, Integer> dishes = new HashMap<>();

    public Order() { }

    public Map<Dish, Integer> getOrder() {
        return dishes;
    }

    public boolean addDish(Dish dish, Integer count) {
        dishes.put(dish, count);

        return true;
    }

    public boolean clearOrder() {
        dishes.clear();

        return true;
    }

}
