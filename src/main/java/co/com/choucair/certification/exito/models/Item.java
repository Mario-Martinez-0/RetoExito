package co.com.choucair.certification.exito.models;

import lombok.Data;

import java.util.Objects;

@Data
public class Item {

    private final String name;
    private final double value;
    private final int amount;

    public Item(String name, double value, int amount) {

        this.name = name;
        this.value = value;
        this.amount = amount + 1;
    }

    public String getName() {
        return name;
    }

    public double getValue() {
        return value;
    }

    public int getAmount() {
        return amount;
    }

    public double totalCost() {
        return value * amount;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", value=" + value +
                ", amount=" + amount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Double.compare(value, item.value) == 0 && amount == item.amount && Objects.equals(name, item.name);
    }

    public boolean equalsName(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(name, item.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, value, amount);
    }
}
