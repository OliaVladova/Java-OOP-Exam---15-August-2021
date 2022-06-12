package restaurant.entities.tables;

import restaurant.common.ExceptionMessages;
import restaurant.entities.drinks.interfaces.Beverages;
import restaurant.entities.healthyFoods.interfaces.HealthyFood;
import restaurant.entities.tables.interfaces.Table;

import java.util.ArrayList;
import java.util.Collection;

public abstract class BaseTable implements Table {
    private Collection<HealthyFood> healthyFood;
    private Collection<Beverages> beverages;
    private int number;
    private int size;
    private int numberOfPeople;
    private double pricePerPerson;
    private boolean isReservedTable = false;
    private double allPeople;

    protected BaseTable(int number, int size, double pricePerPerson) {
        this.number = number;
        this.setSize(size);
        this.pricePerPerson = pricePerPerson;
        this.healthyFood = new ArrayList<>();
        this.beverages = new ArrayList<>();
    }

    public void reserve(int numberOfPeople) {
        if (numberOfPeople <= 0) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_NUMBER_OF_PEOPLE);
        } else {
            this.numberOfPeople = numberOfPeople;
            this.isReservedTable = true;
        }
    }

    public void orderHealthy(HealthyFood food) {
        this.healthyFood.add(food);
    }

    public void orderBeverages(Beverages beverages) {
        this.beverages.add(beverages);
    }


    @Override
    public int getSize() {
        return this.size;
    }

    private void setSize(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_TABLE_SIZE);
        } else {
            this.size = size;
        }
    }

    @Override
    public double pricePerPerson() {
        return this.pricePerPerson;
    }

    @Override
    public boolean isReservedTable() {
        return this.isReservedTable;
    }

    public double bill() {
        double sum = 0;
        for (Beverages beverage : this.beverages) {
            sum += beverage.getPrice();
        }
        for (HealthyFood food : this.healthyFood) {
            sum += food.getPrice();
        }
        double people = this.numberOfPeople * this.pricePerPerson;
        return sum + people;
    }

    public void clear() {
        this.healthyFood.clear();
        this.beverages.clear();
        this.isReservedTable = false;
        this.numberOfPeople = 0;
    }

    public String tableInformation(){
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Table - %d",this.number)).append(System.lineSeparator())
                .append(String.format("Size - %d",this.size)).append(System.lineSeparator())
                .append(String.format("Type - %s",this.getClass().getSimpleName())).append(System.lineSeparator())
                .append(String.format("All price - %.2f",this.pricePerPerson));
        return builder.toString();
    }
    @Override
    public int getTableNumber() {
        return this.number;
    }

    @Override
    public int numberOfPeople() {
        return this.numberOfPeople;
    }


    @Override
    public double allPeople() {
        return this.allPeople;
    }
}
