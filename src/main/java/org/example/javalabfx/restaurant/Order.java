package org.example.javalabfx.restaurant;

import java.util.LinkedList;
import java.util.List;

public class Order {
    private final List<Position> dishes = new LinkedList<>();
    private Double totalPrice = 0d;

    public Double getTotalPrice() {
        return totalPrice;
    }

    public Order() { }

    public List<Position> getPositions() {
        return dishes;
    }

    public boolean addPosition(Dish dish, Integer count) {
        dishes.add(new Position(dish, count));
        totalPrice += dish.getPrice() * count;

        return true;
    }

    public boolean addPositions(List<Position> positions) {
        dishes.addAll(positions);
        recalcTotalOrderPrice();

        return true;
    }

    public boolean clearOrder() {
        dishes.clear();

        return true;
    }

    private boolean recalcTotalOrderPrice() {
        totalPrice = 0d;

        for (Position pos : dishes) {
            totalPrice += pos.getTotalPrice();
        }

        return true;
    }
}
