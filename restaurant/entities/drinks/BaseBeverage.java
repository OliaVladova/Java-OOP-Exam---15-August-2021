package restaurant.entities.drinks;

import restaurant.common.ExceptionMessages;
import restaurant.entities.drinks.interfaces.Beverages;

public abstract class BaseBeverage implements Beverages {
    private String name;
    private int counter;
    private double price;
    private String brand;

    protected BaseBeverage(String name, int counter, double price, String brand) {
        this.setName(name);
        this.setCounter(counter);
        this.setPrice(price);
        this.setBrand(brand);
    }

    @Override
    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        if (name==null||name.trim().isEmpty()){
            throw new IllegalArgumentException(ExceptionMessages.INVALID_NAME);
        }else {
            this.name = name;
        }
    }

    @Override
    public int getCounter() {
        return this.counter;
    }

    private void setCounter(int counter) {
        if (counter<=0){
            throw new IllegalArgumentException(ExceptionMessages.INVALID_COUNTER);
        }else {
            this.counter = counter;
        }
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    private void setPrice(double price) {
        if (price<=0){
            throw new IllegalArgumentException(ExceptionMessages.INVALID_PRICE);
        }else {
            this.price = price;
        }
    }

    @Override
    public String getBrand() {
        return this.brand;
    }

    private void setBrand(String brand) {
        if (brand==null||brand.trim().isEmpty()){
            throw new IllegalArgumentException(ExceptionMessages.INVALID_BRAND);
        }else {
            this.brand = brand;
        }
    }
}
