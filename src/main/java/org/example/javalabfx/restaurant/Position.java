package org.example.javalabfx.restaurant;

public class Position {
    private Dish dish;
    private Integer count;
    private Double totalPrice;

    public Double getTotalPrice() {
        return totalPrice;
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;

        totalPrice = calcTotalPrice();
    }

    public Position(Dish dish, Integer count) {
        this.dish = dish;
        this.count = count;

        totalPrice = calcTotalPrice();
    }

    private Double calcTotalPrice() {
        return dish.getPrice() * count;
    }
}
